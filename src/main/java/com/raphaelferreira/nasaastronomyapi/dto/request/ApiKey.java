package com.raphaelferreira.nasaastronomyapi.dto.request;

public class ApiKey {
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = "&api_key=" + apiKey;
    }
}
