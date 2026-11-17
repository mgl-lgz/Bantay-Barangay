package bantay;

import bantay.http.PingHandler;
import bantay.http.StaticFileHandler;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/api/ping", new PingHandler());      // API route
        server.createContext("/", new StaticFileHandler("public")); // serves the website files

        server.setExecutor(Executors.newFixedThreadPool(8));
        server.start();
        System.out.println("Server running at http://localhost:8080");
    }
}