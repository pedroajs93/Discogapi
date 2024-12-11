package com.pedroajs.mysongapi.adapters.outbound.db.dbo;

import jakarta.persistence.*;


@Entity
@Table(name = "albums")
public class ReleaseDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "release_year")
    private Integer releaseYear;

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private ArtistDBO artist;

    @Column(name = "resource_url")
    private String resourceUrl;

    @Column(name = "role")
    private String role;

    @Column(name = "thumb_url")
    private String thumbUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public ArtistDBO getArtist() {
        return artist;
    }

    public void setArtist(ArtistDBO artist) {
        this.artist = artist;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }
}
