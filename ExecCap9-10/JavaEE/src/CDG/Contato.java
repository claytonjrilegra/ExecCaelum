package CDG;

import java.util.Calendar;

public class Contato {
	
	public Contato(){
		
	}

	  private Long id;
	  private String nome;
	  private String email;
	  private String endereco;
	  private Calendar dataNascimento;
	  
	  
	  
	public Long getId() {
		return id;
	}
	public void setId(long id2) {
		this.id =  id2;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	  
}
