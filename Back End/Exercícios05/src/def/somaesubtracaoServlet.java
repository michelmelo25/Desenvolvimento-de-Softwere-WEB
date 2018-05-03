package def;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/somaesubtracaoServlet")
public class somaesubtracaoServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String n1 = request.getParameter("numero1");
        String n2 = request.getParameter("numero2");

        double numero1 = Double.parseDouble(n1);
        double numero2 = Double.parseDouble(n2);

        double soma = numero1 + numero2;
        double subtracao = numero1 - numero2;

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body>");

        out.println("A soma de: "  + numero1 + " + " + numero2 + " é: " + soma);
        out.println("<br>");
        out.println("A subtração de: "  + numero1 + " - " + numero2 + " é: " + subtracao);

        out.println("</body>");
        out.println("</html>");
    }
}
