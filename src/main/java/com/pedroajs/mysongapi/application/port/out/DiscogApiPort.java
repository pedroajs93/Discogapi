package com.pedroajs.mysongapi.application.port.out;

import com.pedroajs.mysongapi.application.dto.DiscogsArtistReleasesResponse;
import com.pedroajs.mysongapi.domain.artist.Artist;

import java.util.List;

public interface DiscogApiPort {
    List<Artist> searchArtists(String artistName);
    DiscogsArtistReleasesResponse getArtistReleases(Integer artistId);
}
