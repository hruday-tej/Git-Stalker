package com.example.gitstalker.model;

import com.google.gson.annotations.SerializedName;

public class GitHubUser {

//    serialized name is actually the keys that would be used in the json provided to us from the API.. so the things in " " must match the keys that are being sent by the API

    @SerializedName("login")
    public String login;

    @SerializedName("name")
    public String name;

    @SerializedName("followers")
    public String followers;

    @SerializedName("following")
    public String following;

    @SerializedName("avatar_url")
    public String avatar;

    @SerializedName("email")
    public String email;

//    public GitHubUser() {
//    }

    public GitHubUser(String login, String name, String followers, String following, String avatar, String email) {
        this.setLogin(login);
        this.setName(name);
        this.setFollowers(followers);
        this.setFollowing(following);
        this.setAvatar(avatar);
        this.setEmail(email);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
