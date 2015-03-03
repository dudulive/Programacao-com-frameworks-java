package br.com.laboratorio.principal;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.laboratorio.entidades.Produto;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		selectProdutoById();
	}

	private static void insertProduto() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("PU_Lab_01");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		Produto produto = lerProduto();
		// Gravando o produto no banco.
		manager.persist(produto);

		trx.commit();
		manager.close();
		factory.close();
	}

	private static void selectAllProduto() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("PU_Lab_01");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		Query query = manager.createQuery("SELECT p FROM Produto p");
		@SuppressWarnings("unchecked")
		List<Produto> produtos = query.getResultList();
		for (Produto produto : produtos) {
			System.out.println(produto);
		}

		trx.commit();
		manager.close();
		factory.close();
	}

	private static void selectProdutoById() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("PU_Lab_01");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		Scanner input = new Scanner(System.in);
		System.out.println("----------------");
		System.out.println("Informe o id..:");
		Long id = Long.parseLong(input.nextLine());
		Produto produto = manager.find(Produto.class, id);
		System.out.println(produto);
        input.close();
        
		trx.commit();
		manager.close();
		factory.close();
	}

	private static Produto lerProduto() {
		Scanner input = new Scanner(System.in);
		Produto produto = new Produto();
		System.out.println("----------------");
		System.out.println("Informe o id..:");
		produto.setId(Long.parseLong(input.nextLine()));
		System.out.println("Informe o nome:");
		produto.setNome(input.nextLine());
		System.out.println("Informe o tipo:");
		produto.setTipo(input.nextLine());
		System.out.println("Informe o preço:");
		produto.setPreco(Float.parseFloat(input.nextLine()));
		input.close();
		return produto;
	}
}
