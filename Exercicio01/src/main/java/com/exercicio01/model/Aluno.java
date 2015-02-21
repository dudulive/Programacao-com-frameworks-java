package com.exercicio01.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Aluno {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private Double nota01;
	private Double nota02;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nota01 == null) ? 0 : nota01.hashCode());
		result = prime * result + ((nota02 == null) ? 0 : nota02.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nota01 == null) {
			if (other.nota01 != null)
				return false;
		} else if (!nota01.equals(other.nota01))
			return false;
		if (nota02 == null) {
			if (other.nota02 != null)
				return false;
		} else if (!nota02.equals(other.nota02))
			return false;
		return true;
	}
	
	public Double getNota02() {
		return nota02;
	}
	public void setNota02(Double nota02) {
		this.nota02 = nota02;
	}
	public Double getNota01() {
		return nota01;
	}
	public void setNota01(Double nota01) {
		this.nota01 = nota01;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
