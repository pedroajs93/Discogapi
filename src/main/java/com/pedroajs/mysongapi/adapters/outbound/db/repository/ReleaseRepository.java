package com.pedroajs.mysongapi.adapters.outbound.db.repository;

import com.pedroajs.mysongapi.adapters.outbound.db.dbo.ReleaseDBO;
import com.pedroajs.mysongapi.domain.release.Release;

import java.util.List;

public interface ReleaseRepository {
    void saveAll(List<ReleaseDBO> release);
}
