package com.pedroajs.mysongapi.application.dto;

public class ReleaseDTO {

    private Integer id;  // Identificador do release
    private String title;  // Título do álbum
    private Integer releaseYear;  // Ano de lançamento
    private String artistName;  // Nome do artista
    private String resourceUrl;  // URL do recurso do álbum
    private String role;  // Papel do artista (exemplo: "Main")
    private String thumbUrl;  // URL da imagem do álbum

    // Getters e Setters
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

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
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
