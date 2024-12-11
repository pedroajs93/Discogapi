package com.pedroajs.mysongapi.util.mappers;


import com.pedroajs.mysongapi.adapters.outbound.db.dbo.ReleaseDBO;
import com.pedroajs.mysongapi.application.dto.DiscogsReleaseDTO;
import com.pedroajs.mysongapi.domain.release.Release;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AlbumMapper {
    private ArtistMapper artistMapper;

    public Release toDomain(DiscogsReleaseDTO discogsReleaseDTO) {
        Release release = new Release();
        release.setTitle(discogsReleaseDTO.getTitle());
        release.setReleaseYear(discogsReleaseDTO.getYear());

        return release;
    }

    public List<Release> toDomain(List<DiscogsReleaseDTO> discogsReleaseDTOList) {
        return discogsReleaseDTOList.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    public List<ReleaseDBO> toDBO(List<Release> releases) {
        return releases.stream()
                .map(album -> {
                    ReleaseDBO releaseDBO = new ReleaseDBO();
                    releaseDBO.setTitle(album.getTitle());
                    releaseDBO.setReleaseYear(album.getReleaseYear());
                    return releaseDBO;
                })
                .collect(Collectors.toList());
    }
}
