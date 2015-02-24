package com.laboratorio.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.laboratorio.model.Funcionario;
import com.laboratorio.util.ConnectionFactory;

@ManagedBean(name = "cadastro")
@RequestScoped
public class CadastroBean {

	private Funcionario funcionario = new Funcionario();

	public String actionCadastrar() {
		EntityManager manager = ConnectionFactory.getEntityManager();
		EntityTransaction trx = manager.getTransaction();

		trx.begin();
		manager.persist(funcionario);
		trx.commit();
		manager.close();

		return null;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
