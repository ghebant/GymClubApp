package app.gymclubapp.services;

import java.util.List;

import app.gymclubapp.services.models.RetroResponse;
import app.gymclubapp.services.models.User;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface HttpService {

    @GET("users")
    Call<List<User>> getUsers();

    @POST("users")
    Call<User> postUser(@Body User user);

    @POST("login")
    Call<ResponseBody> login(@Body User user);

    @POST("login")
    Call<RetroResponse> login2(@Body User user);

    /*@POST("users")
    Call<RequestBody> postUser(
            @Part("username") String username,
            @Part("password") String password);*/
}
