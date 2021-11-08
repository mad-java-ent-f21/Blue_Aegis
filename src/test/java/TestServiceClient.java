import org.junit.Test;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceClient {

    @Test
    public void testOurApiJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("our API endpoint here");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        assertEquals("???", response);
    }

    @Test
    public void testOurApiXML() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("our API endpoint here");
        String response = target.request(MediaType.APPLICATION_XML).get(String.class);
        assertEquals("???", response);
    }
}


