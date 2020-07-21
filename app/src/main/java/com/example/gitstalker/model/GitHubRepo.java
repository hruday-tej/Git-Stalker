package com.example.gitstalker.model;

import com.google.gson.annotations.SerializedName;

public class GitHubRepo {

    public GitHubRepo(String name, String description, String language) {
        this.setDescription(description);
        this.setLanguage(language);
        this.setName(name);
    }

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("language")
    private String language;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
