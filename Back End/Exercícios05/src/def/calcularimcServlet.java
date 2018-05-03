package def;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.Math.pow;

@WebServlet("/calcularimcServlet")
public class calcularimcServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String altura = request.getParameter("altura");
        String peso = request.getParameter("peso");

        double alt = Double.parseDouble(altura);
        double pes = Double.parseDouble(peso);

        double imc = pes / pow(alt,2);

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body");

        out.println("<h1> Seu imc é: "  + imc + "</h1>");

        out.println("</body>");
        out.println("</html>");
    }
}
