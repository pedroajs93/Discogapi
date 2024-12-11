package com.pedroajs.mysongapi.application.infra.external;

import com.pedroajs.mysongapi.application.dto.DiscogsApiResponse;
import com.pedroajs.mysongapi.application.dto.DiscogsArtistDTO;
import com.pedroajs.mysongapi.application.dto.DiscogsArtistReleasesResponse;
import com.pedroajs.mysongapi.application.port.out.DiscogApiPort;
import com.pedroajs.mysongapi.domain.artist.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DiscogsClient implements DiscogApiPort {

    @Value("${discogs.api.base-url}")
    private String baseUrl;

    @Value("${discogs.api.token}")
    private String token;

    @Value("${discogs.api.user-agent}")
    private String userAgent;

    private final DiscogsApi discogsApi;

    @Autowired
    public DiscogsClient(Retrofit retrofit) {
        this.discogsApi = retrofit.create(DiscogsApi.class);
    }

    @Override
    public List<Artist> searchArtists(String artistName) {
        try {
            Response<DiscogsApiResponse> response = discogsApi.searchArtists(artistName, "artist", token, userAgent).execute();

            if (response.isSuccessful() && response.body() != null) {
                return response.body().getResults().stream()
                        .map(result -> new Artist(result.getId(), result.getTitle()))
                        .collect(Collectors.toList());
            } else {
                throw new RuntimeException("Failed to fetch artists: " +
                        (response.errorBody() != null ? response.errorBody().string() : "Unknown error"));
            }
        } catch (IOException e) {
            throw new RuntimeException("Error occurred while searching for artists", e);
        }
    }




    @Override
    public DiscogsArtistReleasesResponse getArtistReleases(Integer artistId) {
        try {
            Response<DiscogsArtistReleasesResponse> response = discogsApi.getArtistReleases(artistId, token, userAgent).execute();

            if (response.isSuccessful() && response.body() != null) {
                return response.body();
            } else {
                throw new RuntimeException("Failed to fetch releases for artist ID: " + artistId + " - " +
                        (response.errorBody() != null ? response.errorBody().string() : "Unknown error"));
            }
        } catch (IOException e) {
            throw new RuntimeException("Error occurred while fetching artist releases", e);
        }
    }

}

