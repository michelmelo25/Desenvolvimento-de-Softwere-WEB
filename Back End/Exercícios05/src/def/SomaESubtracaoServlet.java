package def;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("SomaESubtracaoServlet")
public class SomaESubtracaoServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        double numero1 = Double.parseDouble(request.getParameter("numero1"));
        double numero2 = Double.parseDouble(request.getParameter("numero2"));

        double soma = numero1 + numero2;
        double subtracao = numero1 - numero2;

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<body");

        out.println("A soma de: "  + numero1 + " + " + numero2 + " é: " + soma);
        out.println("A subtração de: "  + numero1 + " - " + numero2 + " é: " + subtracao);

        out.println("</body>");
        out.println("</html>");
    }
}
