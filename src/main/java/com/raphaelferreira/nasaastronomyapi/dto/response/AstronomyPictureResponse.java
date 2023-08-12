package com.raphaelferreira.nasaastronomyapi.dto.response;


public class AstronomyPictureResponse {
    private String copyright;
    private String date;
    private String explanation;
    private String title;

    public AstronomyPictureResponse(String copyright, String date, String explanation, String title) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.title = title;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getTitle() {
        return title;
    }
}
