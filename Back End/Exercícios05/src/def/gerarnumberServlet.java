package def;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

@WebServlet(name = "gerarnumberServlet")
public class gerarnumberServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Integer> resultado = new ArrayList<Integer>();
        ArrayList<Integer> numeros = new ArrayList<Integer>();

        for(int i = 1; i<=60; i++){
            numeros.add(i);
        }
        Collections.shuffle(numeros);

        for (int i = 0; i < 6; i++){
            resultado.add(numeros.get(i));
        }
        Collections.sort(resultado);

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body");

        out.println("<h1> Resultado </h1>");
        for (Integer valor : resultado) {
                out.println(valor + " ");
        }
        
        out.println("</body>");
        out.println("</html>");
    }
}
