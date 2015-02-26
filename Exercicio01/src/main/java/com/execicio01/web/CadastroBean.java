package com.execicio01.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.exercicio01.model.Aluno;
import com.exercicio01.util.ConnectionFactory;

@ManagedBean(name = "cadastro")
@RequestScoped
public class CadastroBean {

	private Aluno aluno = new Aluno(); 
	
	public String actionCadastrar() {
		EntityManager manager = ConnectionFactory.getEntityManager();
		EntityTransaction trx = manager.getTransaction();

		trx.begin();
		manager.persist(aluno);
		trx.commit();
		manager.close();

		return null;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
}
