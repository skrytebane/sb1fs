package no.sparebank1.sb1fs.saul.http;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;


public class OldSchoolHttpServer {
    static final int port = 8080;
    static final String newLine = "\r\n";

    private static Logger LOG = LoggerFactory.getLogger(OldSchoolHttpServer.class);


    public static void serveJson() {
        new Thread(() -> serve()).start();
    }

    public static void serve() {
        try {
            try (ServerSocket socket = new ServerSocket(port)) {

                boolean b = true;

                while (b) {
                    LOG.info("HTTP server listening on port {}", port);
                    Socket connection = socket.accept();

                    try {
                        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        OutputStream out = new BufferedOutputStream(connection.getOutputStream());
                        PrintStream pout = new PrintStream(out);

                        // read first line of request
                        String request = in.readLine();
                        if (request == null) continue;

                        LOG.info(request);
                        // we ignore the rest
                        while (true) {
                            String ignore = in.readLine();
                            if (ignore == null || ignore.length() == 0) break;
                        }

                        if (!request.startsWith("GET ") ||
                                !(request.endsWith(" HTTP/1.0") || request.endsWith(" HTTP/1.1"))) {
                            // bad request
                            pout.print("HTTP/1.0 400 Bad Request" + newLine + newLine);
                        } else {

                            String response = new Scanner(OldSchoolHttpServer.class.getResourceAsStream("/saul/better-call-saul.json"), "UTF-8").useDelimiter("\\A").next();

                            pout.print(
                                    "HTTP/1.0 200 OK" + newLine +
                                            "Content-Type: application/json" + newLine +
                                            "Date: " + new Date() + newLine +
                                            "Content-length: " + response.length() + newLine + newLine +
                                            response
                            );
                        }

                        pout.close();
                    } catch (Throwable tri) {
                        LOG.error("Error handling request: ", tri);
                    }
                }
            }
        } catch (Throwable tr) {
            System.err.println("Could not mount server: " + tr);
        }
    }
}