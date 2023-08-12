package com.raphaelferreira.nasaastronomyapi.main;

import com.raphaelferreira.nasaastronomyapi.dto.request.ApiKey;
import com.raphaelferreira.nasaastronomyapi.dto.request.AstronomyPictureRequest;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        int option;
        String date = "";
        String apiKey = "";
        final int QTY_DATES = 2;
        String dates[] = new String[QTY_DATES];
        Scanner input = new Scanner(System.in);
        System.out.println("Testing requests using Java and Astronomy Picture Nasa API!");
        System.out.println("Select by some date or Start Date and End Date to search new Astronomy Picture Nasa API.");
        System.out.println("Type date format in this way: YYYY-MM-DD.");

        System.out.print("Type your authorization code: ");
        apiKey = input.next();
        ApiKey myApiKey = new ApiKey();
        myApiKey.setApiKey(apiKey);
        System.out.println(myApiKey.getApiKey());

        System.out.println("Select one option: [1]-> One Date   [2]-> Start Date and End Date");
        System.out.print("Type one the options: ");
        option = input.nextInt();

        System.out.println("Selected option: " + option);

        if (option == 1) {
            try {
                System.out.println("Type the date: ");
                date = input.next();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            for (int i = 0; i < QTY_DATES; i++) {
                System.out.println("Type the date: ");
                dates[i] = input.next();
            }
        }

        AstronomyPictureRequest myRequest1 = new AstronomyPictureRequest(date + myApiKey.getApiKey());
        myRequest1.requestFromApi(myRequest1.getUrl());

        AstronomyPictureRequest myRequest2 = new AstronomyPictureRequest(dates[0],dates[1] + myApiKey.getApiKey());
        myRequest2.requestFromApi();

    }
}
