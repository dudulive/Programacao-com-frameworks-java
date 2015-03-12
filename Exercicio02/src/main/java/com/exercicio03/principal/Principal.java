package com.exercicio03.principal;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.exercicio03.entidades.Aluno;



public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				Scanner input = new Scanner(System.in);
				boolean sair = false;

				do {
					System.out.println("Escolha a opção desejada: ");
					System.out.println("\t1 - INCLUIR Aluno: ");
					System.out.println("\t2 - EXCLUIR Aluno: ");
					System.out.println("\t3 - ALTERAR Aluno: ");
					System.out.println("\t4 - CONSULTAR Aluno: ");
					System.out.println("\t5 - LISTAR AlunoS: ");
					System.out.println("\t6 - SAIR:");
					System.out.println("Informe a opção: ");

					int opt = Integer.parseInt(input.nextLine());

					switch (opt) {
					case 1:
						insertAluno();
						break;
					case 2:
						deleteAluno();
						break;
					case 3:
						updateAluno();
						break;
					case 4:
						selectAlunoById();
						break;
					case 5:
						selectAllAluno();
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

			private static void selectAlunoById() {
				EntityManagerFactory factory = Persistence
						.createEntityManagerFactory("PU_EXER_02");
				EntityManager manager = factory.createEntityManager();
				EntityTransaction trx = manager.getTransaction();
				trx.begin();

				@SuppressWarnings("resource")
				Scanner input = new Scanner(System.in);
				System.out.print("Informe o id:");
				Integer id = Integer.parseInt(input.nextLine());
				Aluno Aluno = manager.find(Aluno.class, id);
				System.out.println(Aluno);
				//input.close();

				trx.commit();
				manager.close();
				factory.close();
			}

			private static void selectAllAluno() {
				EntityManagerFactory factory = Persistence
						.createEntityManagerFactory("PU_EXER_02");
				EntityManager manager = factory.createEntityManager();
				EntityTransaction trx = manager.getTransaction();
				trx.begin();

				Query query = manager.createQuery("SELECT p FROM Aluno p");
				@SuppressWarnings("unchecked")
				List<Aluno> Alunos = query.getResultList();

				for (Aluno Aluno : Alunos) {
					System.out.println(Aluno);
				}

				trx.commit();
				manager.close();
				factory.close();
			}

			private static void insertAluno() {
				EntityManagerFactory factory = Persistence
						.createEntityManagerFactory("PU_EXER_02");
				EntityManager manager = factory.createEntityManager();
				EntityTransaction trx = manager.getTransaction();
				trx.begin();

				Aluno Aluno = lerAluno();
				// Gravando o Aluno no banco.
				manager.persist(Aluno);

				trx.commit();
				manager.close();
				factory.close();
			}

			private static void updateAluno() {
				EntityManagerFactory factory = Persistence
						.createEntityManagerFactory("PU_EXER_02");
				EntityManager manager = factory.createEntityManager();
				EntityTransaction trx = manager.getTransaction();
				trx.begin();

				selectAllAluno();
				@SuppressWarnings("resource")
				Scanner input = new Scanner(System.in);
				System.out.println("Informe o id do Aluno: ");
				Integer id = Integer.parseInt(input.nextLine());
				// Gravando o Aluno no banco
				Aluno Aluno = manager.find(Aluno.class, id);
				System.out.println("---------------------------");
				System.out.print("Informe o nome.: ");
				Aluno.setNome(input.nextLine());
				System.out.print("Informe o idade.: ");
				Aluno.setIdade(Integer.parseInt(input.nextLine()));
				System.out.print("Informe o peso: ");
				Aluno.setPeso(Float.parseFloat(input.nextLine()));

				trx.commit();
				manager.close();
				factory.close();
			}

			private static void deleteAluno() {
				EntityManagerFactory factory = Persistence
						.createEntityManagerFactory("PU_EXER_02");
				EntityManager manager = factory.createEntityManager();
				EntityTransaction trx = manager.getTransaction();
				trx.begin();

				selectAllAluno();
				@SuppressWarnings("resource")
				Scanner input = new Scanner(System.in);
				System.out.println("Informe o id do Aluno: ");
				Integer id = Integer.parseInt(input.nextLine());
				Aluno Aluno = manager.find(Aluno.class, id);
				manager.remove(Aluno);

				trx.commit();
				manager.close();
				factory.close();
			}

			private static Aluno lerAluno() {
				@SuppressWarnings("resource")
				Scanner input = new Scanner(System.in);
				Aluno Aluno = new Aluno();
				System.out.println("---------------------------");
				System.out.print("Informe o id...: ");
				Aluno.setId(Integer.parseInt(input.nextLine()));
				System.out.print("Informe o nome.: ");
				Aluno.setNome(input.nextLine());
				System.out.print("Informe o Idade.: ");
				Aluno.setIdade(Integer.parseInt(input.nextLine()));
				System.out.print("Informe o Peso: ");
				Aluno.setPeso(Float.parseFloat(input.nextLine()));
				//input.close();
				return Aluno;
			}
}
