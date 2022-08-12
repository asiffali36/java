package com.example.lse_bot;

import com.example.lse_bot.model.Component;
import com.example.lse_bot.model.Payload;
import com.example.lse_bot.model.NewsModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Scraper {
    String url = "https://api.londonstockexchange.com/api/v1/components/refresh";
    String origin = "https://www.londonstockexchange.com";
    String referer = "https://www.londonstockexchange.com/";
    String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5112.81 Safari/537.36 Edg/104.0.1293.47";
    String content_type = "application/json";

    public void getNews() throws IOException, JSONException {
        NewsModel newsModel = new NewsModel();
        ArrayList<NewsModel> simpleArrayList = new ArrayList<>();
        Payload payload = new Payload();
        ArrayList<Component> arrayList = new ArrayList(Arrays.asList(new Component("block_content%3A431d02ac-09b8-40c9-aba6-04a72a4f2e49",null)));
        payload.setComponents(arrayList);
        payload.setPath("news");
        for(int i=0;i<=7;i++) {
            payload.setParameters("tab%3Dnews-explorer%26" +
                    "page%" +
                    "3" +
                    "D" + i +
                    "%26tabId%3D58734a12-d97c-40cb-8047-df76e660f23f");
            ObjectMapper objectMapper =new ObjectMapper();

            String stringAsJason=  objectMapper.writeValueAsString(payload);
           // System.out.println(stringAsJason);
        for (int j = 0; j < 1; j++)
        {

            Connection.Response response = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .followRedirects(true)
                    .ignoreHttpErrors(true)
                    .userAgent(userAgent)
                    .method(Connection.Method.POST)
                    .header("content-type", content_type)
                    .header("accept", content_type)
                    .header("referer", referer)
                    .requestBody(String.valueOf(stringAsJason))
                    .method(Connection.Method.POST)
                    .execute();


            int statusCode = response.statusCode();
            System.out.println(statusCode);
      //      System.out.println(response.body());
            JSONArray jsonArray = new JSONArray(response.body());

            String companyName = (String) jsonArray.getJSONObject(0).getJSONArray("content").getJSONObject(1).getJSONObject("value").getJSONArray("content").getJSONObject(j).get("companyname");
            String issuerName =  (String) jsonArray.getJSONObject(0).getJSONArray("content").getJSONObject(1).getJSONObject("value").getJSONArray("content").getJSONObject(j).get("issuername");
            String datetime = (String) jsonArray.getJSONObject(0).getJSONArray("content").getJSONObject(1).getJSONObject("value").getJSONArray("content").getJSONObject(j).get("datetime");


            simpleArrayList.add(new NewsModel(companyName,issuerName,datetime));





        }}

        System.out.println(simpleArrayList);
    }
}
