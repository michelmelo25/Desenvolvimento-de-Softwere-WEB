package def;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/login")
public class login extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.cadastrarPessoa("Michel", "12345");

        Usuario user = usuarioDAO.buscarPessoa(login,senha);


        if(user != null){
            sessao.setAttribute("usuarioLogado", login);
            response.sendRedirect("telaInicial");
//            out.println("<h1> Logado </h1>");
        }else{
            response.sendRedirect("TelaErro");
//            out.println("<h1> Nao Cadastrado </h1>");
        }

    }
}
