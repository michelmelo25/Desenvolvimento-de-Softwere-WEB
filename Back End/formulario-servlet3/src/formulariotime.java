import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/formulariotime")
public class formulariotime extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        String nome = request.getParameter("nome");
        String time = request.getParameter("time");
        String [] dados = request.getParameterValues("preferencias");

        out.println("Nome: " + nome + " Time: " + time);
        out.println("Preferencias: "+ Arrays.toString(dados));
        out.println("</body>");
        out.println("</html>");
    }
}
