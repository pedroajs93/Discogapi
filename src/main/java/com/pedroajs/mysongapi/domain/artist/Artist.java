package com.pedroajs.mysongapi.domain.artist;

import java.util.List;

public class Artist {
    private Integer id;  // Identificador do artista
    private String name;  // Nome do artista
    private String profile;  // Descrição do artista
    private String resourceUrl;  // URL do recurso do artista
    private String uri;  // URI do artista na Discogs
    private List<String> urls;  // URLs associadas ao artista (site oficial, Wikipedia, etc.)
    private String dataQuality;  // Qualidade dos dados
    private List<String> nameVariations;  // Variações de nome do artista
    private List<Member> members;  // Lista de membros do artista

    public Artist(Integer id, String title) {
        this.id = id;
        this.name = title;
    }

    public Artist() {}

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public String getDataQuality() {
        return dataQuality;
    }

    public void setDataQuality(String dataQuality) {
        this.dataQuality = dataQuality;
    }

    public List<String> getNameVariations() {
        return nameVariations;
    }

    public void setNameVariations(List<String> nameVariations) {
        this.nameVariations = nameVariations;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}

