package com.pedroajs.mysongapi.application.dto;

public class DiscogsReleaseDTO {
    private String artist;
    private Integer id;
    private Integer main_release;
    private String resource_url;
    private String role;
    private String thumb;
    private String title;
    private String type;
    private Integer year;
    private String format; // Para suportar casos onde existe o campo "format"
    private String label;  // Para suportar casos onde existe o campo "label"
    private String status; // Para suportar casos onde existe o campo "status"

    // Getters e Setters
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMain_release() {
        return main_release;
    }

    public void setMain_release(Integer main_release) {
        this.main_release = main_release;
    }

    public String getResource_url() {
        return resource_url;
    }

    public void setResource_url(String resource_url) {
        this.resource_url = resource_url;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
