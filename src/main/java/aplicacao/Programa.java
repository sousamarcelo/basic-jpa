package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		/* foram inseridos com sucesso
		Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
		Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");
		*/
		
		
		//iniciando persistencia com banco, esses dois objetos são padrões para comunicação com banxo
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		/* *** inseridos com sucesso ***
		////inserindo os objetos no banxo
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		*/
		
		/* *** Recuparando dados do banco ***
		Pessoa p = em.find(Pessoa.class, 2); //função que busca o objeto pelo id, no primeiro argumento é passado a Classe pessoa, no segundo o Id.
		
		System.out.println(p);
		
	
		*/
		
		/* *** Apagando uma pessoa do banco de dados ***
		/* objetos precisa estarr monitorado para que o jpa consiga realizar uma deleção por exemplo. ou seja as conexões do em e emf precisar estar abertar
		 * ou para deletar primeiro busca o objeto no banco e depois deleta ainda com a conexão do em e emf aberta. exemplo 
		 * outro detalhe importaçõ: toda operação que  não seja um simples consulta deve estar no meio de uma transação --> em.getTransaction().begin(); e em.getTransaction().commit();
		 * complementado: para manupular o objeto do banco ele precisa ser monitorado e para isso ou ele precisa ou um objeto que acabou de ser inserido ou precisa recuperado-lo do banco */
		
		Pessoa p = em.find(Pessoa.class, 2); //primeiro busca no banco a pessoa que se deseja apagar do banco
		
		em.getTransaction().begin();
		em.remove(p); //depois sim pode apaga-la porque ela ainda está monitora, a conexão do em e emf ainda está aberta
		em.getTransaction().commit();
				
		System.out.println("Pronto!");
		//fechando os objetos necessarios
		em.clear(); //fechando o "EntityManager" depois de utilizalo
		emf.close(); //fechando o "EntityManagerFactory" depois de utilizalo
		
		
		

	}

}
