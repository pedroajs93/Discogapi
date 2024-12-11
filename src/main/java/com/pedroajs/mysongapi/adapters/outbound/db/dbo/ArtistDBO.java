package com.pedroajs.mysongapi.adapters.outbound.db.dbo;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "artists")
public class ArtistDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "profile")
    private String profile;

    @Column(name = "resource_url")
    private String resourceUrl;

    @Column(name = "uri")
    private String uri;

    @Column(name = "data_quality")
    private String dataQuality;

    @ElementCollection
    @CollectionTable(name = "artist_name_variations", joinColumns = @JoinColumn(name = "artist_id"))
    @Column(name = "name_variation")
    private List<String> nameVariations;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    private List<MemberDBO> members;

    public ArtistDBO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public ArtistDBO() {}
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

    public List<MemberDBO> getMembers() {
        return members;
    }

    public void setMembers(List<MemberDBO> members) {
        this.members = members;
    }
}
