package com.raphaelferreira.nasaastronomyapi.dto.response;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.net.http.HttpClient;
import java.util.ArrayList;

public class AstronomyPictureResponseHandler {
    private static final Gson gson = new Gson();
    private static final HttpClient httpClient = HttpClient.newHttpClient();

    public static ArrayList<AstronomyPictureResponse> astronomyPictureResponse(String reponseBody) {
        return gson.fromJson(reponseBody, new TypeToken<ArrayList<AstronomyPictureResponse>>(){}.getType());
    }

    public static AstronomyPictureResponse astronomyPictureResponse(String responseBody, String url) {
        return gson.fromJson(responseBody, AstronomyPictureResponse.class);
    }
}
