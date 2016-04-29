package br.com.clayton.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.clayton.model.Tarefa;

public class TarefaDao {
	
		
		private Connection connection;
 
		public TarefaDao(Connection connection) {
			    this.connection = connection;
			  }
		  
		public TarefaDao() {
			    this.connection = new ConnectionFactory().getConnection();
			  }
		  
		  
		  
		public void adiciona(Tarefa tarefa) {
			    String sql = "insert into tarefas " +
			            "(descricao,finalizado)" +
			            " values (?,?)";

			    try {
			     
			        PreparedStatement stmt = connection.prepareStatement(sql);

			    		       
			        stmt.setString(1,tarefa.getDescricao());
			        stmt.setBoolean(2,tarefa.isFinalizado());
			        stmt.setDate(3, new Date(
			                tarefa.getDataFinalizacao().getTimeInMillis()));

			      
			        stmt.execute();
			        stmt.close();
			    } catch (SQLException e) {
			        throw new RuntimeException(e);
			    }
			}
		  
		  
		  
		public List<Tarefa> ListaTarefa() {
			  
			 try{ 
			  List<Tarefa> tarefas = new ArrayList<Tarefa>();
			  PreparedStatement stmt = this.connection.prepareStatement("select * from tarefas");	  
			  ResultSet rs = stmt.executeQuery();
			  

						while (rs.next()) {

						
						    Tarefa tarefa = new Tarefa();
						    
						    tarefa.setId(rs.getLong("id"));
						    tarefa.setDescricao(rs.getString("descricao"));
						    tarefa.setFinalizado(rs.getBoolean("finalizado"));
						    
						   
						    Calendar data = Calendar.getInstance();
						    data.setTime(rs.getDate("dataFinalizacao"));
						    tarefa.setDataFinalizacao(data);

						   
						 

						  
						    tarefas.add(tarefa);
						}

			rs.close();
			stmt.close();

						
	       return tarefas;
			 }catch(SQLException e){
				 throw new RuntimeException(e);
			 }
		} 
			  
		  
		  public Tarefa Pesquisar(int id){
			 /* try{ 
				  
				  PreparedStatement stmt = this.connection.prepareStatement("select * from contatos where id ='"+id+"';" );	  
				  ResultSet rs = stmt.executeQuery();
				  
				  
				  				Tarefa tarefa = new Tarefa();
							    
				  				tarefa.setId(rs.getLong("id"));
				  				tarefa.setNome(rs.getString("nome"));
				  				tarefa.setEmail(rs.getString("email"));
				  				tarefa.setEndereco(rs.getString("endereco"));

							 
				  			stmt.close();

							
				return tarefa;
				 }catch(SQLException e){
					 throw new RuntimeException(e);
				 }    
			  */
			  return null;
		  }
		  

			public void Altera(Tarefa tarefa) {
				String sql = "update contatos set nome=?, email=?," + "endereco=?, dataNascimento=? where id=?";

				try {
					PreparedStatement stmt = connection.prepareStatement(sql);
					stmt.setString(1, tarefa.getDescricao());
					stmt.setBoolean(2, tarefa.isFinalizado());
					
					 stmt.setDate(3, new Date(
				                tarefa.getDataFinalizacao().getTimeInMillis()));
				
					stmt.setLong(4, tarefa.getId());
					stmt.execute();
					stmt.close();
					System.out.println("Alterado com sucesso");
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}

			public void Remove(Tarefa tarefa) {
				try {
					PreparedStatement stmt = connection.prepareStatement("delete from contatos where id=?");
					stmt.setLong(1, tarefa.getId());
					stmt.execute();
					stmt.close();
					System.out.println("Removido com sucesso");
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		 
		  



}
