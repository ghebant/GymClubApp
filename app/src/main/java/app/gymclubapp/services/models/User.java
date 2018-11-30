package app.gymclubapp.services.models;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
