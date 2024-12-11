package com.pedroajs.mysongapi.application.infra.external;

import com.pedroajs.mysongapi.application.dto.DiscogsApiResponse;
import com.pedroajs.mysongapi.application.dto.DiscogsArtistReleasesResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface DiscogsApi {

    @GET("database/search")
    Call<DiscogsApiResponse> searchArtists(
            @Query("q") String artistName,
            @Query("type") String type,
            @Header("Authorization") String authorization,
            @Header("User-Agent") String userAgent
    );

    @GET("artists/{id}/releases")
    Call<DiscogsArtistReleasesResponse> getArtistReleases(
            @Query("id") Integer artistId,
            @Header("Authorization") String authorization,
            @Header("User-Agent") String userAgent
    );
}
