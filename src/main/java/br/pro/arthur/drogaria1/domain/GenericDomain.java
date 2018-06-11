package br.pro.arthur.drogaria1.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial")

/*a classe não vai ser uma tabela*/
@MappedSuperclass

public class GenericDomain implements Serializable{
	
	/*o proximo atributo é a chave primaria*/
	@Id 
	
	/*pra o banco saber que o artibuto é de auto incremento*/
	@GeneratedValue(strategy = GenerationType.AUTO) 
	
	private Long codigo;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	
}
