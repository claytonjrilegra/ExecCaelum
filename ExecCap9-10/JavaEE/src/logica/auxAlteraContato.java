package logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CDG.Contato;
import DAO.ContatoDao;

public class auxAlteraContato implements Logica{

	 public String executa(HttpServletRequest req, HttpServletResponse res)
		        throws Exception {

		      
		      List<Contato> contatos = new ContatoDao().ListaContato();

		      req.setAttribute("contatos", contatos);
		  
		      return "alteraContato.jsp";
		  }
	
}
