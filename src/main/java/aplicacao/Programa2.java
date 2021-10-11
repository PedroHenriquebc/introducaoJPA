package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa2 {
	
//ESSE PROGRAMA BUSCA UMA PESSOA DO BANCO DE DADOS
	
	public static void main(String[] args) {
		//Entity Manager Factory cria o Entity Manager
		//Entity Manager faz a conexão e o acesso a dados
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		//em.find é uma função que busca um objeto pelo id
		Pessoa p = em.find(Pessoa.class, 2); //Passar como parametro a classe.class e o id
		
		System.out.println(p);
		
		System.out.println("Pronto!");
		em.close();
		emf.close();
	}

}
