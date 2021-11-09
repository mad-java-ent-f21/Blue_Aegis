import com.sun.security.ntlm.Client;
import com.swapi.Planet;
import org.junit.Test;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceClient {

        @Test
        public void testswapiJSON() throws Exception {
            Client client = ClientBuilder.newClient();
            WebTarget target =
                    client.target("https://swapi.dev/api/planets/1");
            String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

            ObjectMapper mapper = new ObjectMapper();
            Planet planet = mapper.ReadValue(response, Planet.class);
            assertEquals("Tatooine", planet.getName());
        }
}

