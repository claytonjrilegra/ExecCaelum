package br.com.clayton.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.clayton.model.Tarefa;

@Repository
public class JdbcTarefaDao {
	
		
		private final Connection connection;
 
		@Autowired
		public JdbcTarefaDao(BasicDataSource mysqlDataSource){
			
				
			try{  
	            this.connection = mysqlDataSource.getConnection();  
	        } catch (SQLException e) {  
	            throw new RuntimeException(e);  
	        }  
				
			  }
		  
		
		  
		  
		  
		public void adiciona(Tarefa tarefa) {
			    String sql = "insert into tarefas " +
			            "(descricao,finalizado, dataFinalizacao)" +
			            " values (?,?,?)";

			    try {
			     
			        PreparedStatement stmt = connection.prepareStatement(sql);

			    		       
			        stmt.setString(1,tarefa.getDescricao());
			        stmt.setBoolean(2,tarefa.isFinalizado());
			        
			        Calendar c = Calendar.getInstance();
			        tarefa.setDataFinalizacao(c);
			        
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
			  
		  
		  public Tarefa Pesquisar(Long id){
			  
			  
			    
			  try{  
				  
				  
				  
				  
				  PreparedStatement stmt = this.connection.prepareStatement("select * from tarefas where id='"+id+"';");	  
				  ResultSet rs = stmt.executeQuery();
				  
					Tarefa tarefa = new Tarefa();
				  while (rs.next()) {
				  
				  			
							    
				  						    
							    tarefa.setId(rs.getLong("id"));	
							    
							    
							    
							    System.out.println(rs.getLong("id"));
							    
							    tarefa.setDescricao(rs.getString("descricao")); 
							    tarefa.setFinalizado(rs.getBoolean("finalizado"));
							    
							    Calendar data = Calendar.getInstance();
							    data.setTime(rs.getDate("dataFinalizacao"));
							    tarefa.setDataFinalizacao(data);
							    
								
				  }
							 
							rs.close();    
				  			stmt.close();

							
				  			return tarefa;
				
				 }catch(SQLException e){
					 throw new RuntimeException(e);
				 }
  
			  
			  
		  }
		  

			public void Altera(Tarefa tarefa) {
				String sql = "update tarefas set descricao=?, finalizado=? where id=?";

				try {
					PreparedStatement stmt = connection.prepareStatement(sql);
					stmt.setString(1, tarefa.getDescricao());
					stmt.setBoolean(2, tarefa.isFinalizado());
					
					 /*stmt.setDate(3, new Date(
				                tarefa.getDataFinalizacao().getTimeInMillis()));*/
				
					stmt.setLong(3, tarefa.getId());
					stmt.execute();
					stmt.close();
					System.out.println("Alterado com sucesso");
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}

			public void Remove(Tarefa tarefa) {
				try {
					PreparedStatement stmt = connection.prepareStatement("delete from tarefas where id=?");
					stmt.setLong(1, tarefa.getId());
					stmt.execute();
					stmt.close();
					System.out.println("Removido com sucesso");
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		 
		  

			  public void finaliza(Long id){
				  
				  PreparedStatement stmt;
				try {
					stmt = this.connection.prepareStatement("update tarefas set finalizado=?, dataFinalizacao=? where id=?;");
				
					
					
				  Tarefa tarefa = new Tarefa();
				  
				  
				  System.out.println(id);
				  
				  tarefa.setFinalizado(true);
				  tarefa.setId(id);
				  
				  Calendar c = Calendar.getInstance();
				  
				  tarefa.setDataFinalizacao(c);

				  
				  stmt.setBoolean(1, tarefa.isFinalizado());
				  
				  	stmt.setDate(2, new Date(
			             tarefa.getDataFinalizacao().getTimeInMillis()));
				  
				  	stmt.setLong(3, tarefa.getId());
				  	
				  	stmt.execute();
					stmt.close();
				  
				  
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				  
			  }

}
