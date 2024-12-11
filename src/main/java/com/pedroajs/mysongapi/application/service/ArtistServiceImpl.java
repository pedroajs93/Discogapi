package com.pedroajs.mysongapi.application.service;

import com.pedroajs.mysongapi.application.port.out.DiscogApiPort;
import com.pedroajs.mysongapi.application.usecases.ArtistUseCasePort;
import com.pedroajs.mysongapi.domain.artist.Artist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistUseCasePort {
    private final DiscogApiPort discogsApiPort;


    public ArtistServiceImpl(DiscogApiPort discogsApiPort) {
        this.discogsApiPort = discogsApiPort;
    }

    @Override
    public List<Artist> searchArtists(String query) {
        return discogsApiPort.searchArtists(query);
    }

    @Override
    public List<Artist> compareArtists(List<Artist> artists) {
        return List.of();
    }
}
