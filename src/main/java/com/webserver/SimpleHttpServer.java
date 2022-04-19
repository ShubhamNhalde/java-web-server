package com.webserver;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class SimpleHttpServer {

    private HttpServer httpServer;
    public static int port;
    public static int DEFAULT_PORT = 2086;

    private void start(int port) {
        this.port = port;
        try {
            httpServer = HttpServer.create(new InetSocketAddress(port), 0);
            System.out.println("Server started at : " + port);
            httpServer.createContext("/", new Handlers.rootHandler());
            httpServer.createContext("/echoHeader", new Handlers.rootHandler());
            httpServer.createContext("/echoGet", new Handlers.rootHandler());
            httpServer.createContext("/echoPost", new Handlers.rootHandler());
            httpServer.setExecutor(null);
            httpServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        SimpleHttpServer httpServer = new SimpleHttpServer();
        httpServer.start(DEFAULT_PORT);
    }

}
