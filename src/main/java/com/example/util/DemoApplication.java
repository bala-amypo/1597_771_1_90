import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class DemoApplication {

    public static void main(String[] args) throws Exception {
        // Start a Jetty server on port 8080
        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        // Map the servlet
        context.addServlet(new ServletHolder(new DemoServlet()), "/compare");

        server.start();
        System.out.println("Server started at http://localhost:8080");
        server.join();
    }
}
