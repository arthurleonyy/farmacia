package br.pro.arthur.drogaria1.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.arthur.drogaria1.domain.Cidade;
import br.pro.arthur.drogaria1.domain.Pessoa;

public class PessoaDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		
		// criando cidadeDAO
		CidadeDAO cidadeDAO = new CidadeDAO();
			
		Long codigo = 3L;
		
		// capturando cidade
		Cidade cidade = cidadeDAO.buscar(codigo);
			
		// criando pessoa
		Pessoa pessoa = new Pessoa();
		
		// setando os atributos
		pessoa.setNome("adamastor adm");
		pessoa.setCpf("999.999.999-99");
		pessoa.setRg("9.999.999");
		pessoa.setRua("rua 9");
		pessoa.setNumero(new Short("999"));
		pessoa.setBairro("bairro 9");
		pessoa.setCep("99999-999");
		pessoa.setComplemento("complemento 9");
		pessoa.setTelefone("(99)9999-9999");
		pessoa.setCelular("(99)99999-9999");
		pessoa.setEmail("adamastor@gmail.com");
		pessoa.setCidade(cidade);
			
		// criando pessoaDAO
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		// persistindo pessoa no banco
		pessoaDAO.salvar(pessoa);
	
	}
	
	@Test
	@Ignore
	public void listar(){
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		List<Pessoa> resultado = pessoaDAO.listar();
		
		for(Pessoa pessoa : resultado){
			
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("RG: " + pessoa.getCpf());
			System.out.println("CPF: " + pessoa.getCpf());
			System.out.println("Rua: " + pessoa.getRua());
			System.out.println("Numero: " + pessoa.getNumero());
			System.out.println("Bairro: " + pessoa.getBairro());
			System.out.println("CEP: " + pessoa.getCep());
			System.out.println("Compemento: " + pessoa.getComplemento());
			System.out.println("Telefone: " + pessoa.getTelefone());
			System.out.println("Celular: " + pessoa.getCelular());
			System.out.println("Email: " + pessoa.getEmail());
			System.out.println("Cidade: " + pessoa.getCidade().getNome());
			System.out.println(" ");
		}
		
	}
	
	@Test
	@Ignore
	public void buscar(){
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		Long codigo = 2L;
		
		Pessoa pessoa = pessoaDAO.buscar(codigo);
		
		System.out.println("Nome: " + pessoa.getNome());
		System.out.println("RG: " + pessoa.getCpf());
		System.out.println("CPF: " + pessoa.getCpf());
		System.out.println("Rua: " + pessoa.getRua());
		System.out.println("Numero: " + pessoa.getNumero());
		System.out.println("Bairro: " + pessoa.getBairro());
		System.out.println("CEP: " + pessoa.getCep());
		System.out.println("Compemento: " + pessoa.getComplemento());
		System.out.println("Telefone: " + pessoa.getTelefone());
		System.out.println("Celular: " + pessoa.getCelular());
		System.out.println("Email: " + pessoa.getEmail());
		System.out.println("Cidade: " + pessoa.getCidade().getNome());
		
	}
	
	@Test
	@Ignore
	public void exclur(){
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		Long codigo = 5L;
		
		Pessoa pessoa = pessoaDAO.buscar(codigo);
		
		pessoaDAO.excluir(pessoa);
		
		System.out.println("pessoa excluiad com sucesso!");
		
	}
	
	@Test
	@Ignore
	public void editar(){
		
		// instanciando pessoaDAO
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		Long codigoPessoa = 5L, codigoCidade = 2L;
		
		// capturando pessoa pelo codigo da chave primaria
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);
		
		// instanciando CidadeDAO
		CidadeDAO cidadeDAO = new CidadeDAO();
		
		// capturando cidade pelo codigo da chave primaria
		Cidade cidade = cidadeDAO.buscar(codigoCidade);
		
		// setando os novos atributos
		pessoa.setNome("luiz da manga");
		pessoa.setCpf("999.999.999-99");
		pessoa.setRg("9.999.999");
		pessoa.setRua("rua 9");
		pessoa.setNumero(new Short("999"));
		pessoa.setBairro("bairro 9");
		pessoa.setCep("99999-999");
		pessoa.setComplemento("complemento 9");
		pessoa.setTelefone("(99)9999-9999");
		pessoa.setCelular("(99)99999-9999");
		pessoa.setEmail("manga@gmail.com");
		pessoa.setCidade(cidade);
		
		pessoaDAO.editar(pessoa);
		
	}
	
}
