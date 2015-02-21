package com.exercicio01.util;

import javax.persistence.Persistence;

public class TesteConfiguracaoPersistence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persistence.createEntityManagerFactory("Exercicio01");

	}

}
