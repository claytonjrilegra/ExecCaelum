package br.com.clayton.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.clayton.model.Tarefa;
import br.com.clayton.model.Usuario;

public class UsuarioDao {
	
	private Connection connection;
	 
	public UsuarioDao(Connection connection) {
		    this.connection = connection;
		  }
	  
	public UsuarioDao() {
		    this.connection = new ConnectionFactory().getConnection();
		  }
	


	public boolean existeUsuario(Usuario usuario) {
		String sql = "select * from usuarios where usuario = ? and senha = ?";
			try {
				PreparedStatement stmt = this.connection.prepareStatement(sql);
				stmt.setString(1, usuario.getUsuario());
				stmt.setString(2, usuario.getSenha());
					ResultSet rs = stmt.executeQuery();
				stmt.execute();
				
					if(rs.next()) {
						stmt.close();
						return true;
					}
				    else {
					  	stmt.close();
					  	return false;
				  }
	      } catch (SQLException e) {
	    	  throw new RuntimeException(e);
	      }
	 }

	
}