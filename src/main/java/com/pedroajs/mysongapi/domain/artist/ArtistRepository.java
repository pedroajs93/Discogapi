package com.pedroajs.mysongapi.domain.artist;

import com.pedroajs.mysongapi.adapters.outbound.db.dbo.ArtistDBO;

import java.util.Optional;

public interface ArtistRepository {
    Artist save(Artist artist);
    Artist findByName(String name);
    Optional<ArtistDBO> findById(Integer id);
}

