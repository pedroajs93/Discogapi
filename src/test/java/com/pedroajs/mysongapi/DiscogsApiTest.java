package com.pedroajs.mysongapi;

import com.pedroajs.mysongapi.application.dto.DiscogsApiResponse;
import com.pedroajs.mysongapi.application.dto.DiscogsArtistDTO;
import com.pedroajs.mysongapi.application.infra.external.DiscogsApi;

import okhttp3.mockwebserver.MockResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.Call;
import retrofit2.Response;
import okhttp3.mockwebserver.MockWebServer;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DiscogsApiTest {

    private MockWebServer mockWebServer;
    private DiscogsApi discogsApi;

    @Value("${discogs.api.base-url}")
    private String baseUrl;

    @Value("${discogs.api.token}")
    private String token;

    @Value("${discogs.api.user-agent}")
    private String userAgent;


    @BeforeEach
    public void setup() throws Exception {


        mockWebServer = new MockWebServer();
        mockWebServer.start();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mockWebServer.url("/"))
                .addConverterFactory(JacksonConverterFactory.create())
                .build();


        discogsApi = retrofit.create(DiscogsApi.class);
    }

    @Test
    public void testSearchArtists() throws Exception {

        String jsonResponse = "{\n" +
                "  \"pagination\": {\n" +
                "    \"per_page\": 50,\n" +
                "    \"items\": 9,\n" +
                "    \"page\": 1,\n" +
                "    \"pages\": 1\n" +
                "  },\n" +
                "  \"results\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"title\": \"Artist Name\",\n" +
                "      \"resource_url\": \"http://example.com/resource\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        mockWebServer.enqueue(new MockResponse().setBody(jsonResponse)); // Resposta simulada

        Call<DiscogsApiResponse> call = discogsApi.searchArtists("Artist Name", "artist", "token", "userAgent");
        Response<DiscogsApiResponse> response = call.execute();

        assertTrue(response.isSuccessful());
        assertNotNull(response.body());
        assertNotNull(response.body().getResults());

        DiscogsArtistDTO artist = response.body().getResults().get(0);
        assertEquals(1, artist.getId());
        assertEquals("Artist Name", artist.getTitle());
        assertEquals("http://example.com/resource", artist.getResource_url());
    }

    @Test
    public void testSearchArtistsRealApi() throws Exception {

        // Configura o Retrofit para usar a URL real da API
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.discogs.com")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        // Cria a instância da API
        DiscogsApi discogsApi = retrofit.create(DiscogsApi.class);

        // Chama o método para buscar artistas
        Call<DiscogsApiResponse> call = discogsApi.searchArtists("Nickleback", "artist", token, userAgent);
        Response<DiscogsApiResponse> response = call.execute();

        // Verifica se a requisição foi bem-sucedida
        assertTrue(response.isSuccessful(), "API call failed with code: " + response.code());
        assertNotNull(response.body(), "Response body is null");

        // Verifica os resultados
        List<DiscogsArtistDTO> results = response.body().getResults();
        assertNotNull(results, "Results are null");
        assertFalse(results.isEmpty(), "No results found");

        // Valida os dados do primeiro artista
        DiscogsArtistDTO artist = results.get(0);
        assertNotNull(artist.getId(), "Artist ID is null");
        assertNotNull(artist.getTitle(), "Artist title is null");
    }

}
