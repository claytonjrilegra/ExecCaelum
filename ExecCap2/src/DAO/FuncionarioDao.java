package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Jdbc.ConnectionFactory;
import modelo.Contato;
import modelo.Funcionario;

public class FuncionarioDao {
	private Connection connection;

	
	  public FuncionarioDao() {
	    this.connection = new ConnectionFactory().getConnection();
	  }
	  
	  
	  
	  public void adiciona(Funcionario func) {
		    String sql = "insert into funcionario " +
		            "(nome,usuario,senha)" +
		            " values (?,?,?)";

		    try {
		     
		        PreparedStatement stmt = connection.prepareStatement(sql);

		    

		        stmt.setString(1,func.getNome());
		        stmt.setString(2,func.getUsuario());
		        stmt.setString(3,func.getSenha());
		        

		      
		        stmt.execute();
		        stmt.close();
		        
		    } catch (SQLException e) {
		        throw new DaoException(e);
		    }
		}
	  
	  
	  
	  public List<Funcionario> ListaFuncionario() {
		  
		 try{ 
		  List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		  PreparedStatement stmt = this.connection.prepareStatement("select * from funcionario");	  
		  ResultSet rs = stmt.executeQuery();
		  

					while (rs.next()) {

					
					    Funcionario func = new Funcionario();
					    
					    func.setId(rs.getLong("idfuncionario"));
					    func.setNome(rs.getString("nome"));
					    func.setUsuario(rs.getString("usuario"));
					    func.setSenha(rs.getString("senha"));

					   
					   

					  
					    funcionarios.add(func);
					}

		rs.close();
		stmt.close();

					
     return funcionarios;
		 }catch(SQLException e){
			 throw new RuntimeException(e);
		 }
	} 
		  
	  
	  public Funcionario Pesquisar(int id){
		  try{ 
			  
			  PreparedStatement stmt = this.connection.prepareStatement("select * from funcionario where idfuncionario ='"+id+"';" );	  
			  ResultSet rs = stmt.executeQuery();
			  
						
						    Funcionario func = new Funcionario();
						    
						    func.setId(rs.getLong("id"));
						    func.setNome(rs.getString("nome"));
						    func.setUsuario(rs.getString("usuario"));
						    func.setSenha(rs.getString("senha"));

						   
						    
						  
						  

			
			stmt.close();

						
			return func;
			 }catch(SQLException e){
				 throw new RuntimeException(e);
			 }    
		  
	  }
	  

		public void Altera(Funcionario func) {
			String sql = "update funcionario set nome=?, usuario=?," + "senha=? where idfuncionario=?";

			try {
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, func.getNome());
				stmt.setString(2, func.getUsuario());
				stmt.setString(3, func.getSenha());
				stmt.setLong(4, func.getId());
				stmt.execute();
				stmt.close();
				System.out.println("Alterado com sucesso");
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		public void Remove(Funcionario func) {
			try {
				PreparedStatement stmt = connection.prepareStatement("delete from funcionario where id=?");
				stmt.setLong(1, func.getId());
				
				stmt.execute();
				stmt.close();
				
				System.out.println("Removido com sucesso");
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	 

}
