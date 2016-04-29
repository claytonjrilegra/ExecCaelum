package br.com.clayton.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.clayton.dao.TarefaDao;
import br.com.clayton.model.Tarefa;

@Controller
public class TarefaController {

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
	    
	    
	    TarefaDao dao = new TarefaDao();
	    dao.adiciona(tarefa);
	    return "tarefa/adicionada";
  }
	  
	@RequestMapping("listaTarefas")
	public String lista(Model model) {
		
		  TarefaDao dao = new TarefaDao();
		  model.addAttribute("tarefas", dao.ListaTarefa());
		  return "tarefa/lista";
		}
	  
}