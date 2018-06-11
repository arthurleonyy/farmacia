package br.pro.arthur.drogaria1.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.arthur.drogaria1.domain.ItemVenda;
import br.pro.arthur.drogaria1.domain.Produto;
import br.pro.arthur.drogaria1.domain.Venda;

public class ItemVendaDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(1L);
		
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(1L);
		
		ItemVenda itemVenda = new ItemVenda();
		itemVenda.setVenda(venda);
		itemVenda.setProduto(produto);
		itemVenda.setQuantidade(new Short("3"));
		itemVenda.setValorParcial(new BigDecimal("12.25"));
		
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		itemVendaDAO.salvar(itemVenda);
	
	}
	
	@Test
	@Ignore
	public void listar(){
		
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		
		List<ItemVenda> listaItemVenda = itemVendaDAO.listar();
		
		for(ItemVenda itemVenda : listaItemVenda){
			
			System.out.println("Produto: " + itemVenda.getProduto().getDescricao());
			System.out.println("Venda: " + itemVenda.getVenda().getCodigo());
			System.out.println("quantidade: " + itemVenda.getQuantidade());
			System.out.println("valor: " + itemVenda.getValorParcial());
			System.out.println("");
		}
		
	}
	
	@Test
	@Ignore
	public void buscar(){
		
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		ItemVenda itemVenda = itemVendaDAO.buscar(1L);
		
		System.out.println("Produto: " + itemVenda.getProduto().getDescricao());
		System.out.println("Venda: " + itemVenda.getVenda().getCodigo());
		System.out.println("quantidade: " + itemVenda.getQuantidade());
		System.out.println("valor: " + itemVenda.getValorParcial());
	}
	
	@Test
	@Ignore
	public void excluir(){
		
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		ItemVenda itemVenda = itemVendaDAO.buscar(5L);
		
		itemVendaDAO.excluir(itemVenda);
		System.out.println("item da venda excluido com sucesso!");
			
	}
	
	@Test
	@Ignore
	public void editar(){
		
		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		ItemVenda itemVenda = itemVendaDAO.buscar(6L);
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(3L);
		
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(2L);
		
		itemVenda.setVenda(venda);
		itemVenda.setProduto(produto);
		itemVenda.setQuantidade(new Short("3"));
		itemVenda.setValorParcial(new BigDecimal("15.00"));
		
		itemVendaDAO.editar(itemVenda);
		System.out.println("ite da venda editado com sucesso!");
	}

}
