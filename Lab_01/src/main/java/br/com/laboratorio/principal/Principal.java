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
		Scanner input = new Scanner(System.in);
		boolean sair = false;

		do {
			System.out.println("Escolha a opção desejada: ");
			System.out.println("\t1 - INCLUIR PRODUTO: ");
			System.out.println("\t2 - EXCLUIR PRODUTO: ");
			System.out.println("\t3 - ALTERAR PRODUTO: ");
			System.out.println("\t4 - CONSULTAR PRODUTO: ");
			System.out.println("\t5 - LISTAR PRODUTOS: ");
			System.out.println("\t6 - SAIR:");
			System.out.println("Informe a opção: ");

			int opt = Integer.parseInt(input.nextLine());

			switch (opt) {
			case 1:
				insertProduto();
				break;
			case 2:
				deleteProduto();
				break;
			case 3:
				updateProduto();
				break;
			case 4:
				selectProdutoById();
				break;
			case 5:
				selectAllProduto();
				break;
			case 6:
				sair = true;
				break;
			default:
				System.out.println("== ERRO - OPÇÃO INVÁLIDA ==");
				break;
			}

		} while (!sair);
		input.close();
		System.out.println("== FIM DO PROGRAMA ==");
	}

	private static void selectProdutoById() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("PU_LAB_01");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("Informe o id:");
		Long id = Long.parseLong(input.nextLine());
		Produto produto = manager.find(Produto.class, id);
		System.out.println(produto);
		//input.close();

		trx.commit();
		manager.close();
		factory.close();
	}

	private static void selectAllProduto() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("PU_LAB_01");
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

	private static void insertProduto() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("PU_LAB_01");
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

	private static void updateProduto() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("PU_LAB_01");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		selectAllProduto();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o id do produto: ");
		long id = Long.parseLong(input.nextLine());
		// Gravando o produto no banco
		Produto produto = manager.find(Produto.class, id);
		System.out.println("---------------------------");
		System.out.print("Informe o nome.: ");
		produto.setNome(input.nextLine());
		System.out.print("Informe o tipo.: ");
		produto.setTipo(input.nextLine());
		System.out.print("Informe o preço: ");
		produto.setPreco(Float.parseFloat(input.nextLine()));

		trx.commit();
		manager.close();
		factory.close();
	}

	private static void deleteProduto() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("PU_LAB_01");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		selectAllProduto();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o id do produto: ");
		long id = Long.parseLong(input.nextLine());
		Produto produto = manager.find(Produto.class, id);
		manager.remove(produto);

		trx.commit();
		manager.close();
		factory.close();
	}

	private static Produto lerProduto() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		Produto produto = new Produto();
		System.out.println("---------------------------");
		System.out.print("Informe o id...: ");
		produto.setId(Long.parseLong(input.nextLine()));
		System.out.print("Informe o nome.: ");
		produto.setNome(input.nextLine());
		System.out.print("Informe o tipo.: ");
		produto.setTipo(input.nextLine());
		System.out.print("Informe o preço: ");
		produto.setPreco(Float.parseFloat(input.nextLine()));
		//input.close();
		return produto;
	}

}
