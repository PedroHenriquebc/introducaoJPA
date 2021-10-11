package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

// ESSE PROGRAMA CRIA OBJETOS DO TIPO PESSOA E SALVA NO BANCO DE DADOS

public class Programa {

	public static void main(String[] args) {
		Pessoa p1 = new Pessoa(null, "Pedro Henrique", "pedro@gmail.com");
		Pessoa p2 = new Pessoa(null, "Marcel Joseph", "marcel@gmail.com");
		Pessoa p3 = new Pessoa(null, "Arthur Barros", "tuka12@gmail.com");
		
		//Entity Manager Factory cria o Entity Manager
		//Entity Manager faz a conexão e o acesso a dados
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		
		//Quando o JPA faz alguma operação que não é uma simples leitura do banco de 		    		  dados, ele precisa fazer uma transação:
		em.getTransaction().begin();
		
		//O persist pega o objeto e salva no banco de dados
		em.persist(p1); 
		em.persist(p2);
		em.persist(p3);
		
		em.getTransaction().commit();
		
		
		System.out.println("Pronto!");
		em.close();
		emf.close();
	}

}
