package com.laboratorio.util;

import javax.persistence.Persistence;

public class TesteConfiguracaoPersistence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persistence.createEntityManagerFactory("Laboratorio01");
	}

}
