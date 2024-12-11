package com.pedroajs.mysongapi.application.dto;


import java.util.List;

public class DiscogsReleaseResponse {

    private List<ReleaseDTO> releases;

    public List<ReleaseDTO> getReleases() {
        return releases;
    }

    public void setReleases(List<ReleaseDTO> releases) {}
}