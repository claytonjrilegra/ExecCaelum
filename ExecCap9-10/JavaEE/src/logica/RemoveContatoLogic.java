package logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CDG.Contato;
import DAO.ContatoDao;

public class RemoveContatoLogic implements Logica{

	 public String executa(HttpServletRequest req, HttpServletResponse res)
		      throws Exception {

		    long id = Long.parseLong(req.getParameter("id"));

		    Contato contato = new Contato();
		    contato.setId(id);
		    
		    Connection connection = (Connection) req
	                .getAttribute("connection");

		    ContatoDao dao = new ContatoDao(connection);
		    dao.Remove(contato);

		    System.out.println("Excluindo contato... ");

		    return "mvc?logica=ListaContatosLogic";
		  }

}