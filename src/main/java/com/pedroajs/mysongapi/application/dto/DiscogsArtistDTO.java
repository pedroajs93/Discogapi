package com.pedroajs.mysongapi.application.dto;

import java.util.List;

public class DiscogsArtistDTO {
    private Integer id;  // Identificador do artista
    private String title;  // Nome do artista
    private String profile;  // Descrição do artista
    private String resource_url;  // URL do recurso do artista
    private String uri;  // URI do artista na Discogs
    private List<String> urls;  // URLs associadas ao artista
    private String data_quality;  // Qualidade dos dados
    private List<String> name_variations;  // Variações de nome do artista
    private List<MemberDTO> members;  // Lista de membros do artista

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

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getResource_url() {
        return resource_url;
    }

    public void setResource_url(String resource_url) {
        this.resource_url = resource_url;
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

    public String getData_quality() {
        return data_quality;
    }

    public void setData_quality(String data_quality) {
        this.data_quality = data_quality;
    }

    public List<String> getName_variations() {
        return name_variations;
    }

    public void setName_variations(List<String> name_variations) {
        this.name_variations = name_variations;
    }

    public List<MemberDTO> getMembers() {
        return members;
    }

    public void setMembers(List<MemberDTO> members) {
        this.members = members;
    }
}
