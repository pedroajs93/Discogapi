package com.pedroajs.mysongapi.application.usecases;

import com.pedroajs.mysongapi.domain.artist.Artist;

import java.util.List;

public interface ArtistUseCasePort {
    List<Artist> searchArtists(String query);
    List<Artist> compareArtists(List<Artist> artists);
}
