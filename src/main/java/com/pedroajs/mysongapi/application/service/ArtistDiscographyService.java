package com.pedroajs.mysongapi.application.service;


import com.pedroajs.mysongapi.adapters.outbound.db.dbo.ArtistDBO;
import com.pedroajs.mysongapi.adapters.outbound.db.repository.ReleaseRepository;
import com.pedroajs.mysongapi.application.dto.DiscogsArtistReleasesResponse;
import com.pedroajs.mysongapi.application.port.out.DiscogApiPort;
import com.pedroajs.mysongapi.domain.release.Release;
import com.pedroajs.mysongapi.domain.artist.Artist;
import com.pedroajs.mysongapi.domain.artist.ArtistRepository;
import com.pedroajs.mysongapi.util.mappers.AlbumMapper;
import com.pedroajs.mysongapi.util.mappers.ArtistMapper;
import com.pedroajs.mysongapi.util.mappers.ReleaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArtistDiscographyService {

    private final DiscogApiPort discogsApiPort;
    private final ArtistRepository artistRepositoryPort;
    private final ReleaseRepository releaseRepository;
    private final AlbumMapper albumMapper;
    private final ArtistMapper artistMapper;
    private final ReleaseMapper releaseMapper;

    @Autowired
    public ArtistDiscographyService(DiscogApiPort discogsApiPort,
                                    ArtistRepository artistRepositoryPort,
                                    ReleaseRepository releaseRepository,
                                    AlbumMapper albumMapper,
                                    ArtistMapper artistMapper,
                                    ReleaseMapper releaseMapper
                                    ) {
        this.discogsApiPort = discogsApiPort;
        this.artistRepositoryPort = artistRepositoryPort;
        this.releaseRepository = releaseRepository;
        this.albumMapper = albumMapper;
        this.artistMapper = artistMapper;
        this.releaseMapper = releaseMapper;
    }

    // Método que obtém e armazena a discografia do artista
    public Artist fetchAndStoreDiscography(Integer artistId) {
        DiscogsArtistReleasesResponse releasesResponse = discogsApiPort.getArtistReleases(artistId);

        if (releasesResponse == null || releasesResponse.getReleases() == null) {
            throw new RuntimeException("Failed to fetch releases for artist ID: " + artistId);
        }

        List<Release> releases = albumMapper.toDomain(releasesResponse.getReleases());

        ArtistDBO artistDBO = artistRepositoryPort.findById(artistId).orElse(null);

        if (artistDBO == null) {
            throw new RuntimeException("Artist not found in database with ID: " + artistId);
        }

        Artist artist = artistMapper.toDomain(artistDBO);
        releases.forEach(album -> album.setArtist(artist));

        releaseRepository.saveAll(releaseMapper.toDBO(releases));

        return artist;
    }
}
