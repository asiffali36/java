package com.example.lse_bot;

import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class LseBotApplication {

    public static void main(String[] args) throws IOException, JSONException {
        SpringApplication.run(LseBotApplication.class, args);


    Scraper scraper = new Scraper();
    scraper.getNews();


    }

}
