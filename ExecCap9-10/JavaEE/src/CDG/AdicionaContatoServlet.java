package CDG;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import DAO.ContatoDao;


@WebServlet(name = "MinhaServlet", urlPatterns = {"/adicionaContato2"}) 

public class AdicionaContatoServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
                        
        PrintWriter out = response.getWriter();
                        
       
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String email = request.getParameter("email");
        String dataEmTexto = request.getParameter("dataNascimento");
        Calendar dataNascimento = null;
        
      
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy")
                    .parse(dataEmTexto);
            dataNascimento = Calendar.getInstance();
            dataNascimento.setTime(date);
         
        } catch (java.text.ParseException e) {
        	System.out.println(e);
		}
        
      
        Contato contato = new Contato();
        contato.setNome(nome);
        contato.setEndereco(endereco);
        contato.setEmail(email);
        contato.setDataNascimento(dataNascimento);
        
        // salva o contato
        ContatoDao dao = new ContatoDao();
        dao.adiciona(contato);
        
        // imprime o nome do contato que foi adicionado
        RequestDispatcher rd = request
        	    .getRequestDispatcher("/contato-adicionado.jsp");
        	rd.forward(request,response);
    }

}
