package com.pedroajs.mysongapi.adapters.outbound.db.repository;

import com.pedroajs.mysongapi.adapters.outbound.db.dbo.ReleaseDBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaReleaseRepository extends JpaRepository<ReleaseDBO, Integer> {
    List<ReleaseDBO> findByArtistId(Integer artistId);
}
