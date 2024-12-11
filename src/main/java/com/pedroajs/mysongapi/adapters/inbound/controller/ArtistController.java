package com.pedroajs.mysongapi.adapters.inbound.controller;

import com.pedroajs.mysongapi.application.service.ArtistDiscographyService;
import com.pedroajs.mysongapi.application.usecases.ArtistUseCasePort;
import com.pedroajs.mysongapi.domain.artist.Artist;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    private final ArtistUseCasePort artistUseCasePort;
    private final ArtistDiscographyService artistDiscographyService;


    public ArtistController(ArtistUseCasePort artistUseCasePort, ArtistDiscographyService artistDiscographyService) {
        this.artistUseCasePort = artistUseCasePort;
        this.artistDiscographyService = artistDiscographyService;
    }

    @GetMapping("/search")
    public ResponseEntity<Artist> searchAndStoreArtist(@RequestParam String query) {
        try {
            Artist artist = artistDiscographyService.fetchAndStoreDiscography(Integer.valueOf(query));
            return ResponseEntity.ok(artist);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
