package br.pro.arthur.drogaria1.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.arthur.drogaria1.domain.Cidade;
import br.pro.arthur.drogaria1.domain.Estado;

public class CidadeDAOTest {
	
	@Test @Ignore
	// a cidade precisa do estado, então primeiro seleciona o estado pra depois salvar a cidade 
	public void salvar(){
		
		EstadoDAO estadoDAO = new EstadoDAO();
		
		// selecionando o estado
		Estado estado = estadoDAO.buscar(6L);
		
		Cidade cidade = new Cidade();
		
		// setando o nome da cidade
		cidade.setNome("Santa Catarina");
		
		// recebendo estado
		cidade.setEstado(estado);
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		
		// persistindo cidade no banco
		cidadeDAO.salvar(cidade);
	}

	@Test @Ignore
	public void listar(){
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		
		// criando uma lista que recebe o metodo listar
		List<Cidade> resultado = cidadeDAO.listar();
		
		// for que cria a cidade e recebe resultado 1 a 1
		for(Cidade cidade : resultado){	
			
			System.out.println("Código da Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
			System.out.println();
		}
		
	}
	
	@Test @Ignore
	public void buscar(){
		
		Long codigo = 3L;
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		
		// buscando a cidade pela chave primaria
		cidadeDAO.buscar(codigo);
	
		Cidade cidade = new Cidade();
		
		// imprimindo...
		System.out.println("Código da Cidade: " + cidade.getCodigo());
		System.out.println("Nome da Cidade: " + cidade.getNome());
		System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
		System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
		System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
		System.out.println();
	}
	
	@Test @Ignore
	public void excluir(){
		
		Long codigo = 5L;
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		
		// criando cidade e recebendo a cidade da posição da chave primaria
		Cidade cidade = cidadeDAO.buscar(codigo);
		
		// fazendo o delete de cidade no banco
		cidadeDAO.excluir(cidade);
	}

	
	public void editar(){
		
		Long codigoCidade = 3L;
		Long codigoEstado = 6L;
		
		// instanciando estadoDAO
		EstadoDAO estadoDAO = new EstadoDAO();
		
		Estado estado = estadoDAO.buscar(codigoEstado);
		
		System.out.println("Código do Estado: " + estado.getCodigo());
		System.out.println("Sigla do Estado: " + estado.getSigla());
		System.out.println("Nome do Estado: " + estado.getNome());
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCidade);
		
		System.out.println("Cidade A Ser Editada");
		System.out.println("Código da Cidade: " + cidade.getCodigo());
		System.out.println("Nome da Cidade: " + cidade.getNome());
		System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
		System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
		System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
		
		cidade.setNome("Guarapuava");
		cidade.setEstado(estado);
		
		cidadeDAO.editar(cidade);
		
		System.out.println("Cidade Editada");
		System.out.println("Código da Cidade: " + cidade.getCodigo());
		System.out.println("Nome da Cidade: " + cidade.getNome());
		System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
		System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
		System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
	}
	
	
}
