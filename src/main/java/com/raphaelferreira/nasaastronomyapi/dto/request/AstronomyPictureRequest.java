package com.raphaelferreira.nasaastronomyapi.dto.request;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

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
        System.out.println("URL Request: " + this.url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().GET().timeout(Duration.ofSeconds(15)).uri(URI.create(this.url)).build();
        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }
}
