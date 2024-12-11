package com.pedroajs.mysongapi.domain.artist;

public class Member {
    private Integer id;
    private String name;
    private String resourceUrl;

    public Member(Integer id, String name, String resourceUrl) {
        this.id = id;
        this.name = name;
        this.resourceUrl = resourceUrl;
    }

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

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }
}
