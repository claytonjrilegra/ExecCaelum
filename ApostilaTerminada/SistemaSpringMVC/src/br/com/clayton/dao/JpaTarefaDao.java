package br.com.clayton.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.clayton.model.Tarefa;

@Repository
public class JpaTarefaDao implements TarefaDao{
	
	
	@PersistenceContext
	EntityManager manager;
	
	public void adiciona(Tarefa tarefa) {
	      manager.persist(tarefa);
	    }

	public void altera(Tarefa tarefa) {
	      manager.merge(tarefa);
	    }

	public List<Tarefa> lista() {
	      return manager.createQuery("select t from Tarefa t")
	        .getResultList();
	    }

	public Tarefa buscaPorId(Long id) {
	      return manager.find(Tarefa.class, id);
	    }

	public void remove(Tarefa tarefa) {
	      Tarefa tarefaARemover = buscaPorId(tarefa.getId());
	      manager.remove(tarefaARemover);
	    }

	public void finaliza(Long id) {
	      Tarefa tarefa = buscaPorId(id);
	      tarefa.setFinalizado(true);
	      
	      SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
	      
	      String data="";
	       
	      Calendar hoje = Calendar.getInstance();
	       
	      data = formatoData.format(hoje.getTime());
	      
	      
	      tarefa.setDataFinalizacao(data);
	    }
	

}
