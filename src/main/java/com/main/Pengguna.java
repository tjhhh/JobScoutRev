package com.main;

public class Pengguna {
    private int idPengguna;
    private String username;
    private String password;
    private int follower;
    private int following;

    public Pengguna(int idPengguna, String username, String password, int follower, int following) {
        this.idPengguna = idPengguna;
        this.username = username;
        this.password = password;
        this.follower = follower;
        this.following = following;
    }

    public int getIdPengguna() {
        return idPengguna;
    }

    public void setIdPengguna(int idPengguna) {
        this.idPengguna = idPengguna;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFollower() {
        return follower;
    }

    public void setFollower(int follower) {
        this.follower = follower;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }
}
