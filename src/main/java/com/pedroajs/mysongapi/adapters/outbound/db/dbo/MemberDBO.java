package com.pedroajs.mysongapi.adapters.outbound.db.dbo;


import jakarta.persistence.*;

@Entity
@Table(name="members")
public class MemberDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String resourceUrl;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private ArtistDBO artist;

    public MemberDBO(Integer id, String name, String resourceUrl) {
        this.id = id;
        this.name = name;
        this.resourceUrl = resourceUrl;
    }

    public MemberDBO() {

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

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }
}
