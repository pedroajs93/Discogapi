package com.pedroajs.mysongapi.application.dto;

public class MemberDTO {
    private Integer id;
    private String name;
    private String resource_url;


    public MemberDTO(Integer id, String name, String resource_url) {
        this.id = id;
        this.name = name;
        this.resource_url = resource_url;
    }

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

    public String getResource_url() {
        return resource_url;
    }

    public void setResource_url(String resource_url) {
        this.resource_url = resource_url;
    }
}
