package br.com.clayton.jpa;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.clayton.model.Tarefa;

public class AdicionaTarefa {
	
	public static void main(String[] args) {

	    Tarefa tarefa = new Tarefa();
	    tarefa.setDescricao("Estudar mais Jae");
	    tarefa.setFinalizado(false);
	    SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
	      
	    String data="";
	    Calendar hoje = Calendar.getInstance(); 
	    data = formatoData.format(hoje.getTime());
	    tarefa.setDataFinalizacao(data);

	    EntityManagerFactory factory = Persistence.
	          createEntityManagerFactory("tarefas");
	    EntityManager manager = factory.createEntityManager();

	    manager.getTransaction().begin();    
	    manager.persist(tarefa);
	    manager.getTransaction().commit();  

	    System.out.println("ID da tarefa: " + tarefa.getId());

	    manager.close();
	  }

}
