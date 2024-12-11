package com.pedroajs.mysongapi.util.mappers;

import com.pedroajs.mysongapi.adapters.outbound.db.dbo.ArtistDBO;
import com.pedroajs.mysongapi.adapters.outbound.db.dbo.MemberDBO;
import com.pedroajs.mysongapi.application.dto.DiscogsArtistDTO;
import com.pedroajs.mysongapi.domain.artist.Artist;
import com.pedroajs.mysongapi.domain.artist.Member;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArtistMapper {

    public Artist toDTO(ArtistDBO artistDBO) {
        Artist artist = new Artist();
        artist.setId(artistDBO.getId());
        artist.setName(artistDBO.getName());
        artist.setProfile(artistDBO.getProfile());
        artist.setResourceUrl(artistDBO.getResourceUrl());
        artist.setUri(artistDBO.getUri());
        artist.setDataQuality(artistDBO.getDataQuality());
        artist.setNameVariations(artistDBO.getNameVariations());

        if (artistDBO.getMembers() != null) {
            artist.setMembers(artistDBO.getMembers().stream()
                    .map(memberDBO -> new Member(
                            memberDBO.getId(),
                            memberDBO.getName(),
                            memberDBO.getResourceUrl()
                    ))
                    .collect(Collectors.toList()));
        }

        return artist;
    }

    public ArtistDBO toDBO(Artist artist) {
        ArtistDBO artistDBO = new ArtistDBO();
        artistDBO.setId(artist.getId());
        artistDBO.setName(artist.getName());
        artistDBO.setProfile(artist.getProfile());
        artistDBO.setResourceUrl(artist.getResourceUrl());
        artistDBO.setUri(artist.getUri());
        artistDBO.setDataQuality(artist.getDataQuality());
        artistDBO.setNameVariations(artist.getNameVariations());

        if (artist.getMembers() != null) {
            artistDBO.setMembers(artist.getMembers().stream()
                    .map(member -> new MemberDBO(
                            member.getId(),
                            member.getName(),
                            member.getResourceUrl()
                    ))
                    .collect(Collectors.toList()));
        }

        return artistDBO;
    }

    public List<Artist> toDomain(List<DiscogsArtistDTO> dtoList) {
        return dtoList.stream()
                .map(dto -> new Artist(dto.getId(), dto.getTitle()))
                .collect(Collectors.toList());
    }

    public Artist toDomain(ArtistDBO artistDBO) {
        Artist artist = new Artist();
        artist.setId(artistDBO.getId());
        artist.setName(artistDBO.getName());
        artist.setProfile(artistDBO.getProfile());
        artist.setResourceUrl(artistDBO.getResourceUrl());
        artist.setUri(artistDBO.getUri());
        artist.setDataQuality(artistDBO.getDataQuality());
        artist.setNameVariations(artistDBO.getNameVariations());

        if (artistDBO.getMembers() != null) {
            artist.setMembers(artistDBO.getMembers().stream()
                    .map(memberDBO -> new Member(
                            memberDBO.getId(),
                            memberDBO.getName(),
                            memberDBO.getResourceUrl()
                    ))
                    .collect(Collectors.toList()));
        }

        return artist;
    }
}
