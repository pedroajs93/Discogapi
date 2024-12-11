package com.pedroajs.mysongapi.adapters.outbound.db.repository;

import com.pedroajs.mysongapi.adapters.outbound.db.dbo.ReleaseDBO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReleaseRepositoryImpl implements ReleaseRepository{
    private final JpaReleaseRepository jpaReleaseRepository;

    public ReleaseRepositoryImpl(JpaReleaseRepository jpaReleaseRepository) {
        this.jpaReleaseRepository = jpaReleaseRepository;
    }

    @Override
    public void saveAll(List<ReleaseDBO> release) {
        jpaReleaseRepository.saveAll(release);
    }
}
