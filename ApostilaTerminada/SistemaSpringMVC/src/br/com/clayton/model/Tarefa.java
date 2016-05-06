package br.com.clayton.model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Tarefa {

	
	  @Id
	  @GeneratedValue
	  private Long id;
	  private String descricao; 
	  private boolean finalizado;
	  
	  
	  @DateTimeFormat(pattern = "dd/MM/yyyy")
	  @Temporal(TemporalType.DATE)
	  private Calendar dataFinalizacao;
	  
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isFinalizado() {
		return finalizado;
	}
	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	public Calendar getDataFinalizacao() {
		return dataFinalizacao;
	}
	public void setDataFinalizacao(String dataFinalizacao)
	{	
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		
		Calendar c = Calendar.getInstance();
		 
		try {
			c.setTime(formatoData.parse(dataFinalizacao));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.dataFinalizacao = c;
	}
	  
	  
	
}
