package br.pro.arthur.drogaria1.dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.arthur.drogaria1.domain.Cliente;
import br.pro.arthur.drogaria1.domain.Pessoa;

public class ClienteDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		// capturando pesoa da posição da tabela
		Pessoa pessoa = pessoaDAO.buscar(5l);
		
		Cliente cliente = new Cliente();
				
		// setando os atributos de cliente
		cliente.setPessoa(pessoa);
		cliente.setDataCadastro(new Date());
		cliente.setLiberado(true);

		ClienteDAO clienteDAO = new ClienteDAO();
		
		// salvando cliente...
		clienteDAO.salvar(cliente);
	}
	
	@Test
	@Ignore
	public void listar(){
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		// criando lista do tipo pessoa que recebe o metodo listar 
		List<Cliente> lista = clienteDAO.listar();
		
		// laço que percorre a lista
		for(Cliente cliente  : lista){
			
			// imprimindo clientes
			System.out.println("Cliente: " + cliente.getPessoa().getNome());
			System.out.println("Data de cadastro: " + cliente.getDataCadastro());
			
			//tratando a exibição do status
			if(cliente.getLiberado() == true){
				
				System.out.println("Status: Liberado" );	
			} else{
				
				System.out.println("Status: Bloqueado" );	
			}
			
			System.out.println("" );	
			
		}	
		
	}
	
	
	@Test
	@Ignore
	public void buscar(){
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		Cliente cliente = clienteDAO.buscar(3l);
		
		// imprimindo clientes
		System.out.println("Cliente: " + cliente.getPessoa().getNome());
		System.out.println("Data de cadastro: " + cliente.getDataCadastro());
		
		if(cliente.getLiberado() == true){
			
			System.out.println("Status: Liberado" );	
		} else{
			
			System.out.println("Status: Bloqueado" );	
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		Cliente cliente = clienteDAO.buscar(1l);
		
		clienteDAO.excluir(cliente);
		
		System.out.println("Cliente excluido com sucesso!");
		
	}
	
	@Test
	@Ignore
	public void editar(){
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		// capturando cliente
		Cliente cliente = clienteDAO.buscar(2l);
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		// capturando pessoa
		Pessoa pessoa = pessoaDAO.buscar(2L);
		
		// alterando os atributos de cliente
		cliente.setPessoa(pessoa);
		cliente.setDataCadastro(new Date());
		cliente.setLiberado(false);
		
		clienteDAO.editar(cliente);
		
		System.out.println("cliente editado com sucesso!");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
