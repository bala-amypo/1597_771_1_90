package com.example.util;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class DemoApplication {

    public static void main(String[] args) throws Exception {

        Server server = new Server(8080);

        ServletContextHandler context =
                new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        server.setHandler(context);

        // ✅ CORRECT WAY (PASS CLASS, NOT OBJECT)
        context.addServlet(DemoServlet.class, "/demo");

        server.start();
        server.join();
    }
}
