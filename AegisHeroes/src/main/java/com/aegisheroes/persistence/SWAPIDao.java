package com.aegisheroes.persistence;

import com.sun.security.ntlm.Client;
import com.swapi.Planet;

import java.awt.*;

public class SWAPIDao {

    Planet getPlanet() {
        Client client = ClientBuilder.newClient();

        //Should be reading in a URI from a properties file
        WebTarget target = client.target("https://swapi.dev/api/planets/1");
        String response = target.request(PageAttributes.MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        Planet planet = null;

        try {
            planet = mapper.ReadValue(response, Planet.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return planet;

    }

}

