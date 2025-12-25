import util.TextSimilarityUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/compare")
public class DemoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String text1 = request.getParameter("text1");
        String text2 = request.getParameter("text2");

        double similarityScore = TextSimilarityUtil.similarity(text1, text2);

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("Similarity score: " + similarityScore);
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.getWriter().println("Send POST request with text1 and text2 parameters.");
    }
}
