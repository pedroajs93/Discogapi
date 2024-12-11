package com.pedroajs.mysongapi.util.mappers;

import com.pedroajs.mysongapi.adapters.outbound.db.dbo.ArtistDBO;
import com.pedroajs.mysongapi.adapters.outbound.db.dbo.ReleaseDBO;
import com.pedroajs.mysongapi.application.dto.ReleaseDTO;
import com.pedroajs.mysongapi.domain.artist.Artist;
import com.pedroajs.mysongapi.domain.release.Release;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReleaseMapper {

    // Mapper para DBO
    public ReleaseDBO toDBO(Release release) {
        if (release == null) return null;

        ReleaseDBO releaseDBO = new ReleaseDBO();
        releaseDBO.setId(release.getId());
        releaseDBO.setTitle(release.getTitle());
        releaseDBO.setReleaseYear(release.getReleaseYear());
        releaseDBO.setArtist(release.getArtist() != null ? new ArtistDBO(release.getArtist().getId(), release.getArtist().getName()) : null);
        releaseDBO.setResourceUrl(release.getResourceUrl());
        releaseDBO.setRole(release.getRole());
        releaseDBO.setThumbUrl(release.getThumbUrl());

        return releaseDBO;
    }

    public List<ReleaseDBO> toDBO(List<Release> releases) {
        if (releases == null || releases.isEmpty()) return List.of();

        return releases.stream()
                .map(this::toDBO)
                .collect(Collectors.toList());
    }

    // Mapper DBO to Domain
    public Release toDomain(ReleaseDBO releaseDBO) {
        if (releaseDBO == null) return null;

        Release release = new Release();
        release.setId(releaseDBO.getId());
        release.setTitle(releaseDBO.getTitle());
        release.setReleaseYear(releaseDBO.getReleaseYear());
        release.setArtist(releaseDBO.getArtist() != null ? new Artist(releaseDBO.getArtist().getId(), releaseDBO.getArtist().getName()) : null);
        release.setResourceUrl(releaseDBO.getResourceUrl());
        release.setRole(releaseDBO.getRole());
        release.setThumbUrl(releaseDBO.getThumbUrl());

        return release;
    }

    // Mapper para DTO
    public ReleaseDTO toDTO(Release release) {
        if (release == null) return null;

        ReleaseDTO releaseDTO = new ReleaseDTO();
        releaseDTO.setId(release.getId());
        releaseDTO.setTitle(release.getTitle());
        releaseDTO.setReleaseYear(release.getReleaseYear());
        releaseDTO.setArtistName(release.getArtist() != null ? release.getArtist().getName() : null);
        releaseDTO.setResourceUrl(release.getResourceUrl());
        releaseDTO.setRole(release.getRole());
        releaseDTO.setThumbUrl(release.getThumbUrl());

        return releaseDTO;
    }

    // Mapper de DTO para Domain
    public Release toDomain(ReleaseDTO releaseDTO) {
        if (releaseDTO == null) return null;

        Release release = new Release();
        release.setId(releaseDTO.getId());
        release.setTitle(releaseDTO.getTitle());
        release.setReleaseYear(releaseDTO.getReleaseYear());
        release.setArtist(new Artist(null, releaseDTO.getArtistName())); // Assumindo que o ID não é conhecido no DTO
        release.setResourceUrl(releaseDTO.getResourceUrl());
        release.setRole(releaseDTO.getRole());
        release.setThumbUrl(releaseDTO.getThumbUrl());

        return release;
    }
}
