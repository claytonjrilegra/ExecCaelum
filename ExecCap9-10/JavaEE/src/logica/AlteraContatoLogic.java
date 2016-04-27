package logica;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CDG.Contato;
import DAO.ContatoDao;

@WebServlet(name = "MinhaServlet2", urlPatterns = {"/Altera-Contato"})
public class AlteraContatoLogic extends HttpServlet implements Logica {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
		      throws ServletException, IOException {
		
		
	
		
		    long id = Long.parseLong(req.getParameter("id"));
		    String nome = req.getParameter("nome");
		    String email = req.getParameter("email");
		    String endereco = req.getParameter("endereco");
		    String dataEmTexto = req.getParameter("dataNascimento");
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
		    contato.setId(id);
		    contato.setNome(nome);
		    contato.setEmail(email);
		    contato.setEndereco(endereco);
		    contato.setDataNascimento(dataNascimento);
		    
		    Connection connection = (Connection) req
	                .getAttribute("connection");

		    ContatoDao dao = new ContatoDao(connection);
		    dao.Altera(contato);

		    System.out.println("Contato Alterado ");
		    
		    RequestDispatcher rd1 = req
	        	    .getRequestDispatcher("mvc?logica=ListaContatosLogic");
	        rd1.forward(req,res);

		    
		  }

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

	
	
}
