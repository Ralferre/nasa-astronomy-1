package com.raphaelferreira.nasaastronomyapi.dto.request;

import com.raphaelferreira.nasaastronomyapi.dto.response.AstronomyPictureResponse;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import static com.raphaelferreira.nasaastronomyapi.dto.response.AstronomyPictureResponseHandler.astronomyPictureResponse;

public class AstronomyPictureRequest {
    private String url;
    private String date;
    private String startDate;
    private String endDate;

    public AstronomyPictureRequest(String date) {
        this.date = date;
        this.url = "https://api.nasa.gov/planetary/apod?date=" + this.date;
    }

    public AstronomyPictureRequest(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.url = "https://api.nasa.gov/planetary/apod?start_date=" + this.startDate + "&end_date=" + this.endDate;
    }

    public String getDate() {
        return date;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getUrl() {
        return url;
    }

    public void requestFromApi() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(this.url)).build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            ArrayList<AstronomyPictureResponse> astronomyPictureResponseArrayList = astronomyPictureResponse(response.body());
            for (AstronomyPictureResponse astronomyPictureResponse : astronomyPictureResponseArrayList) {
                System.out.println("__________________________________________________________________________");
                System.out.print("\nCopyright: " + astronomyPictureResponse.getCopyright());
                System.out.println("\nDate: " + astronomyPictureResponse.getDate());
                System.out.println("\nTitle: " + astronomyPictureResponse.getTitle());
                System.out.println("\nExplanation: " + astronomyPictureResponse.getExplanation());
                System.out.println("__________________________________________________________________________");
            }
        }
    }

    public void requestFromApi(String url) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            AstronomyPictureResponse astronomyPictureResponse = astronomyPictureResponse(response.body(), url);
            System.out.println("__________________________________________________________________________");
            System.out.print("\nCopyright: " + astronomyPictureResponse.getCopyright());
            System.out.println("\nDate: " + astronomyPictureResponse.getDate());
            System.out.println("\nTitle: " + astronomyPictureResponse.getTitle());
            System.out.println("\nExplanation: " + astronomyPictureResponse.getExplanation());
            System.out.println("__________________________________________________________________________");

        }
    }

}
