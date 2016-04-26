package Teste;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import DAO.ContatoDao;
import modelo.Contato; 

public class TestaLista {

	public static void main(String[] args) throws Exception {
		
		ContatoDao cDao = new ContatoDao();
		Contato testaAltera = new Contato();
		long id = 1;
		
		List<Contato> contatos = cDao.ListaContato();
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		for (Contato contato : contatos) {
			
			  System.out.println("Nome: " + contato.getNome());
			  System.out.println("Email: " + contato.getEmail());
			  System.out.println("Endereço: " + contato.getEndereco());
			  System.out.println("Data de Nascimento: " + 
					 sdf.format(contato.getDataNascimento().getTime()) + "\n");
			}
		
		
		
		/*
		testaAltera.setNome("Joao");
		testaAltera.setEmail("teste@teste.com");
		testaAltera.setEndereco("rua das dores");
		testaAltera.setId(id);
		testaAltera.setDataNascimento(Calendar.getInstance());
		
	     cDao.Altera(testaAltera);
	     */
		//testaAltera.setId(id);
		//cDao.Remove(testaAltera);
	     
	}
}
