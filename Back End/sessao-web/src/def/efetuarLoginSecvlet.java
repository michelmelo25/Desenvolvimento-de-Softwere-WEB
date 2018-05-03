package def;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/efetuarLoginServlet")
public class efetuarLoginSecvlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");

        Pessoa pessoa = new Pessoa(nome, senha);
        sessao.setAttribute("pessoaFormulario", pessoa);
        //sessao.removeAttribute("pessoaFormulario");
        Pessoa pessoa2 = (Pessoa)sessao.getAttribute("pessoaFormulario");
        String idSessao = sessao.getId();

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("Nome: " + pessoa.getNome() + " Senha: " + pessoa.getSenha());
        out.println("<br>");
        out.println("Nome: " + pessoa2.getNome() + " Senha: " + pessoa2.getSenha());
        out.println("IdSessao: " + idSessao);
        out.println("</body>");
        out.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
