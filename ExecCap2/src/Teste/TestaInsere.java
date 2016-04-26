package Teste;
import java.awt.image.ColorConvertOp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;

import DAO.ContatoDao;
import DAO.FuncionarioDao;
import Jdbc.ConnectionFactory;
import modelo.Contato;
import modelo.Funcionario;

public class TestaInsere {
	
	public static void main(String[] args) throws SQLException {
       
		
		 Contato contato = new Contato();
	      contato.setNome("Clayton");
	      contato.setEmail("contato2@caelum.com.br");
	      contato.setEndereco("R. Vergueiro 3185 cj87");
	      contato.setDataNascimento(Calendar.getInstance());

	     
	      ContatoDao bd = new ContatoDao();

	     
	      bd.adiciona(contato);

	      System.out.println("Gravado!");
	  
		
		//Funcionario func = new Funcionario();
		
		//func.setNome("Francisco");
		//func.setUsuario("fr2");
		//func.setSenha("Brasil");
		
		//FuncionarioDao bd = new FuncionarioDao();
		
		//bd.adiciona(func);
	
	}
}
