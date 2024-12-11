package com.pedroajs.mysongapi.adapters.outbound.db.repository;

import com.pedroajs.mysongapi.adapters.outbound.db.dbo.ArtistDBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaArtistRepository extends JpaRepository<ArtistDBO, Integer> {
    Optional<ArtistDBO> findByName(String name);
}
