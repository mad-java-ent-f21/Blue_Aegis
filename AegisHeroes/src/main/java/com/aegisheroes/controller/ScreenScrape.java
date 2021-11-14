package com.aegisheroes.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.ws.rs.Path;
import java.io.IOException;
@Path("/scrape")
public class ScreenScrape {
    @Path("/zeroday")
    public void getZeroDayInitiative() {

        try {
            // Here we create a document object and use JSoup to fetch the website
            Document doc = Jsoup.connect("https://www.zerodayinitiative.com/rss/upcoming").get();

            // With the document fetched, we use JSoup's title() method to fetch the title
            System.out.printf("Title: %s\n", doc.title());

            // the data is wrapped inside item tag
            Elements repositories = doc.getElementsByTag("item");
            for (Element repository : repositories) {
                System.out.println("Title: " + repository.getElementsByTag("title").text());
                System.out.println("Link: " + repository.getElementsByTag("link").text());
                System.out.println("Description: " + repository.getElementsByTag("description").text());
                System.out.println("Published Date: " + repository.getElementsByTag("pubDate").text());
                System.out.println("-------------------------------");
            }

            // In case of any IO errors, we want the messages written to the console
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

