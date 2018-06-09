package br.pro.arthur.drogaria1.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.arthur.drogaria1.domain.Cidade;
import br.pro.arthur.drogaria1.domain.Fabricante;
import br.pro.arthur.drogaria1.domain.Produto;

@SuppressWarnings("unused")
public class ProdutoDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		
		// capturando o fabricante...
		Fabricante fabricante = fabricanteDAO.buscar(1l);
		
		Produto produto = new Produto();
		
		// setando os atributos...
		produto.setDescricao("produto 1");
		produto.setFabricante(fabricante); 
		produto.setPreco(new BigDecimal("50.00"));
		produto.setQuantidade(new Short("10"));
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		// persistindo no banco
		produtoDAO.salvar(produto);
		
	}
	
	@Ignore
	@Test
	public void listar(){
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		/*
		produto.setDescricao("Cataflan 50mg 20 comprimidos");
		produto.setFabricante(fabricante);
		produto.setPreco(new BigDecimal("13.70"));
		produto.setQuantidade(new Short("50"));
		*/
		
		// criando uma lista que recebe o metodo listar
		List<Produto> resultado = produtoDAO.listar();
		
		// for que cria o produto e recebe resultado 1 a 1
		for(Produto produto : resultado){	
			
			System.out.println("Nome do medicamento: " + produto.getDescricao());
			System.out.println("Fabricante: " + produto.getFabricante().getDescricao());
			System.out.println("Preco: " + produto.getPreco());
			System.out.println("Quantidade: " + produto.getQuantidade());
			System.out.println();
		}
		
	}   
	
	@Ignore
	@Test
	public void buscar(){
		
		Long codigo = 3L;
		
		ProdutoDAO produtoDAO = new ProdutoDAO();

		Produto produto = produtoDAO.buscar(codigo);
		
		// imprimindo...
		System.out.println("Nome do medicamento: " + produto.getDescricao());
		System.out.println("Fabricante: " + produto.getFabricante().getDescricao());
		System.out.println("Preco: " + produto.getPreco());
		System.out.println("Quantidade: " + produto.getQuantidade());
		System.out.println();
	}
	
	@Ignore
	@Test
	public void excluir(){
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		Long codigo = 5L;
		
		Produto produto = produtoDAO.buscar(codigo);
		
		produtoDAO.excluir(produto);	
		
	}
	
	@Test
	@Ignore
	public void editar(){
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		Long codigo = 4L;
		
		Produto produto  = produtoDAO.buscar(codigo);
		
		produto.setDescricao("Diane35");
		produto.getFabricante().setCodigo(codigo);
		produto.setPreco(new BigDecimal("12.50"));
		produto.setQuantidade(new Short("10"));
		
		produtoDAO.editar(produto);
		
	}
	
}
