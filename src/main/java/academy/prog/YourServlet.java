package academy.prog;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/your-servlet-url")
public class YourServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Map<String, Integer> question1Results = new HashMap<>();
    private Map<String, Integer> question2Results = new HashMap<>();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String question1 = req.getParameter("question1");
        String question2 = req.getParameter("question2");

        // Підрахувати кількість голосів для кожного варіанту відповіді
        question1Results.put(question1, question1Results.getOrDefault(question1, 0) + 1);
        question2Results.put(question2, question2Results.getOrDefault(question2, 0) + 1);

        // Повернути результати користувачеві
        PrintWriter out = resp.getWriter();
        out.println("<h2>Результати:</h2>");
        out.println("<p>Question 1:</p>");
        out.println("<ul>");
        for (Map.Entry<String, Integer> entry : question1Results.entrySet()) {
            out.println("<li>" + entry.getKey() + ": " + entry.getValue() + "</li>");
        }
        out.println("</ul>");

        out.println("<p>Question 2:</p>");
        out.println("<ul>");
        for (Map.Entry<String, Integer> entry : question2Results.entrySet()) {
            out.println("<li>" + entry.getKey() + ": " + entry.getValue() + "</li>");
        }
        out.println("</ul>");
    }
}
