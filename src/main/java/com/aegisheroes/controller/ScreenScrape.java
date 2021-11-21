package com.aegisheroes.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.io.IOException;
@Path("/scrape")
public class ScreenScrape {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getZeroDayInitiative() {
    	String dataToPrint = "";
    	
        try {
        	// Using Jsoup library to connect to the REST service.
            Document doc = Jsoup.connect("https://www.zerodayinitiative.com/rss/upcoming").get();

            // Print the main title element from the document in the console.
            System.out.printf("Title: %s\n", doc.title());

            // the data is wrapped inside an item tag so fetch the item tag
            Elements repositories = doc.getElementsByTag("item");
            // iterate each item and retrieve data
            for (Element repository : repositories) {
                System.out.println("Title: " + repository.getElementsByTag("title").text());
                System.out.println("Link: " + repository.getElementsByTag("link").text());
                System.out.println("Description: " + repository.getElementsByTag("description").text());
                System.out.println("Published Date: " + repository.getElementsByTag("pubDate").text());
                System.out.println("-------------------------------");
                
                // since DAO is not ready, print the data on the web to demo it is working.
                dataToPrint += "Title: " + repository.getElementsByTag("title").text() + "\n"
                		+ "Link: " + repository.getElementsByTag("link").text() + "\n";
            }

            // if error is encountered then print stacktrace.
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return dataToPrint;
    }
}

