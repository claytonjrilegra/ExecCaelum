package br.com.clayton.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.clayton.dao.TarefaDao;
import br.com.clayton.model.Tarefa;


@Transactional
@Controller 
public class TarefaController {
	
	@Autowired
	 TarefaDao dao;

	@RequestMapping("novaTarefa")
	  public String form() {
	    return "tarefa/formulario";
	  }

	  
	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
	   
		  //System.out.println(result);
	    
	    if(result.hasFieldErrors("descricao")) {
	        return "tarefa/formulario";
	      }   
	    
	    
	    dao.adiciona(tarefa);
	    return "tarefa/adicionada";
  }
	  
	@RequestMapping("listaTarefas")
	public String lista(Model model) {
		
		  
		  model.addAttribute("tarefas", dao.lista());
		  return "tarefa/lista";
		}
	  
	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) {
			  
			  dao.remove(tarefa);
			  return "redirect:listaTarefas";
		}
	
	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) {
		
	
	  
	  model.addAttribute("tarefa", dao.buscaPorId(id));
	  return "tarefa/mostra";
	}
	
	@RequestMapping("alteraTarefa")
	
	public String altera(Tarefa tarefa) {
		

	  
	  dao.altera(tarefa);
	  
	  return "redirect:listaTarefas";
	}
	
	@RequestMapping("finalizaTarefa")
	public String finaliza(Long id, Model model) {

	  dao.finaliza(id);
	  model.addAttribute("tarefa", dao.buscaPorId(id));
	  return "tarefa/finalizada";
	}
}