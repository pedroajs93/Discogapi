package com.pedroajs.mysongapi.adapters.outbound.db.repository;

import com.pedroajs.mysongapi.adapters.outbound.db.dbo.ArtistDBO;
import com.pedroajs.mysongapi.domain.artist.Artist;
import com.pedroajs.mysongapi.domain.artist.ArtistRepository;
import com.pedroajs.mysongapi.util.mappers.ArtistMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ArtistRepositoryImpl implements ArtistRepository {

    private final JpaArtistRepository jpaArtistRepository;
    private final ArtistMapper artistMapper;

    public ArtistRepositoryImpl(JpaArtistRepository jpaArtistRepository, ArtistMapper artistMapper) {
        this.jpaArtistRepository = jpaArtistRepository;
        this.artistMapper = artistMapper;
    }

    @Override
    public Artist save(Artist artist) {
        var artistDBO = jpaArtistRepository.save(artistMapper.toDBO(artist));
        return artistMapper.toDomain(artistDBO);
    }

    @Override
    public Artist findByName(String name) {
        var artistDBO = jpaArtistRepository.findByName(name).get();
        var artist = artistMapper.toDomain(artistDBO);
        save(artist);
        return artist;
    }

    @Override
    public Optional<ArtistDBO> findById(Integer id) {
       return jpaArtistRepository.findById(id);
    }
}
