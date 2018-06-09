package br.pro.arthur.drogaria1.dao;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.arthur.drogaria1.domain.Cliente;
import br.pro.arthur.drogaria1.domain.Funcionario;
import br.pro.arthur.drogaria1.domain.Venda;

@SuppressWarnings("unused")
public class VendaDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(4l);
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(4l);
		
		Venda venda = new Venda();
		
		// parametro pra cepturar data e hora simultaneamente
		venda.setHorario(new Date(System.currentTimeMillis()));
		
		venda.setCliente(cliente);
		venda.setPrecoTotal(new BigDecimal("125.99"));
		venda.setFuncionario(funcionario);
		
		VendaDAO vendaDAO = new VendaDAO();
		
		vendaDAO.salvar(venda);
	}

	@Test
	@Ignore
	public void listar(){
		
		VendaDAO vendaDAO = new VendaDAO();
		
		List<Venda> listaCliente = vendaDAO.listar();
		
		for(Venda venda : listaCliente){
			
			System.out.println("Preço: " + venda.getPrecoTotal());
			System.out.println("Cliente: " + venda.getCliente().getPessoa().getNome());
			System.out.println("Vendedor: " + venda.getFuncionario().getPessoa().getNome());
			System.out.println("");
			
		}
	
	}
	
	@Test
	@Ignore
	public void buscar(){
		
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(1L);
		
		System.out.println("Preço: " + venda.getPrecoTotal());
		System.out.println("Cliente: " + venda.getCliente().getPessoa().getNome());
		System.out.println("Vendedor: " + venda.getFuncionario().getPessoa().getNome());
	
	}
	
	@Test
	@Ignore
	public void excluir(){
		
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(5L);
		
		vendaDAO.excluir(venda);
		System.out.println("venda excluida com sucesso!");
	}
	
	@Test
	public void editar(){
		
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(2L);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(2l);
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(2l);
		
		venda.setCliente(cliente);
		venda.setPrecoTotal(new BigDecimal("99.90"));
		venda.setFuncionario(funcionario);
		
		vendaDAO.editar(venda);
		
		System.out.println("venda editada com sucesso!");
	}
	
}
