package app.gymclubapp.services.models;

import com.google.gson.annotations.SerializedName;

public class RetroResponse {

    @SerializedName("success")
    private String success;

    public RetroResponse(String success) {
        this.success = success;
    }

    public String getSuccess() {
        return success;
    }
}
