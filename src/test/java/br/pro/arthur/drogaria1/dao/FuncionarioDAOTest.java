package br.pro.arthur.drogaria1.dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.arthur.drogaria1.domain.Funcionario;
import br.pro.arthur.drogaria1.domain.Pessoa;

public class FuncionarioDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(5L);
		
		Funcionario funcionario = new Funcionario();		
		funcionario.setCarteiraTrabalho("111.111.111");
		funcionario.setDataAdmissao(new Date());
		funcionario.setPessoa(pessoa);
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.salvar(funcionario);
	}
	
	@Test
	@Ignore
	public void listar(){
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		
		List<Funcionario> listaFuncionarios = funcionarioDAO.listar();
		
		for(Funcionario funcionario : listaFuncionarios){
			
			System.out.println("Funcionario: " + funcionario.getPessoa().getNome());
			System.out.println("Carteira de trabaho: " + funcionario.getCarteiraTrabalho());
			System.out.println("Data de admissão: " + funcionario.getDataAdmissao());
			System.out.println("");
		}
		
	}
	
	@Test
	@Ignore
	public void buscar(){
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(1L);
		
		System.out.println("Funcionario: " + funcionario.getPessoa().getNome());
		System.out.println("Carteira de trabaho: " + funcionario.getCarteiraTrabalho());
		System.out.println("Data de admissão: " + funcionario.getDataAdmissao());
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(5L);
		
		funcionarioDAO.excluir(funcionario);
		
		System.out.println("funcionario excluido com sucesso!");
	}
	
	@Test
	@Ignore
	public void editar(){
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(4L);
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(4L);
		
		funcionario.setCarteiraTrabalho("000.000.000");
		funcionario.setDataAdmissao(new Date());
		funcionario.setPessoa(pessoa);
		
		funcionarioDAO.editar(funcionario);
		
	}
	
	
	
	
}
