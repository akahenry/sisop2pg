package webservice;

import java.util.logging.Logger;

import java.io.IOException;
import java.net.URI; 
import javax.ws.rs.core.UriBuilder; 
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.net.httpserver.HttpServer;
   
public class Servidor {

    private static final Logger logger = Logger.getLogger(Servidor.class.getName());

    public static void main(String[] args) {
        URI endpoint = UriBuilder.fromUri("http://localhost/").port(9000).build();
        ResourceConfig calculadora_rc = new PackagesResourceConfig("webservice");

        try {
            HttpServer server = HttpServerFactory.create(endpoint, calculadora_rc);
            server.start();
        } catch(IOException e) {
            logger.warning("IOException catched. Exiting application...");
        }
    }
}
