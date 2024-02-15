package com.zylope.zylope.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "logoUrl")
    private String logoUrl;


    @Column(name = "branch")
    private String branch;

    @ManyToMany
    @JoinTable(name = "Posts_Tags",
                joinColumns = @JoinColumn(name = "post_id"),
                inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags;

    @Column(name = "pitch")
    private String pitch;

    @Column(name = "fullDescription")
    private String fullDescription;

    @Column(name = "requirements")
    private String requirements;

    public Post() {
    }

    public Post(String title, String logoUrl, String branch, Set<Tag> tags, String pitch, String fullDescription, String requirements) {
        this.title = title;
        this.logoUrl = logoUrl;
        this.branch = branch;
        this.tags = tags;
        this.pitch = pitch;
        this.fullDescription = fullDescription;
        this.requirements = requirements;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logo_url) {
        this.logoUrl = logo_url;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public String getPitch() {
        return pitch;
    }

    public void setPitch(String pitch) {
        this.pitch = pitch;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }
}
