package br.pro.arthur.drogaria1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")

/*ta falando que a classe é uma entidade de persistencia*/
@Entity
public class Estado extends GenericDomain {
	
	/* @Collum = fala que meu atributo está ligado a uma coluna
	 * NAME = é o nome da coluna 
	 * LENGTH = e o tamanho do campo de caracteres
	 * NULLABLE = é poque o campo não pode ser nulo*/
	
	@Column(length = 2, nullable = false)
	private String sigla;
	
	@Column(length = 50, nullable = false)
	private String nome;
	
	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
