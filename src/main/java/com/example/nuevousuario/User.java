package com.example.nuevousuario;

public class User {
    private String email;
    private String country;
    private String platform;

    public User(String email, String country, String platform) {
        this.email = email;
        this.country = country;
        this.platform = platform;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
