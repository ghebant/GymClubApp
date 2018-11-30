package app.gymclubapp.services;

import android.util.Log;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpClient {

    private static Retrofit retrofit = null;
    private static OkHttpClient.Builder httpClient;

    private HttpService httpService = null;

    public HttpClient() {}

    public static Retrofit getClient() {
        if (retrofit == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .build();
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.43.33:3000/")
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Log.d("LOGTAG", "Check ip current registered is 192.168.43.33");
        }
        return retrofit;
    }
}