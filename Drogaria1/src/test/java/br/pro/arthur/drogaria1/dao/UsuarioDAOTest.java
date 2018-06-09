package br.pro.arthur.drogaria1.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.arthur.drogaria1.domain.Pessoa;
import br.pro.arthur.drogaria1.domain.Usuario;

public class UsuarioDAOTest {

	@Test
	@Ignore
	public void salvar(){
		
		Usuario usuario = new Usuario();
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(5l);

		usuario.setPessoa(pessoa);
		usuario.setAtivo(true);
		usuario.setSenha("123");
		usuario.setTipo('a');
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
		
		System.out.println("usuario salvo com sucesso!");

	}
	
	@Test
	@Ignore
	public void listar(){
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		List<Usuario> listaUsuario = usuarioDAO.listar();
		
		for(Usuario usuario : listaUsuario){
			
			System.out.println("Usuario: " + usuario.getPessoa().getNome());
			System.out.println("Senha: " + usuario.getSenha());
			System.out.println("Tipo de Usuario: " + usuario.getTipo());
			
			if(usuario.getAtivo() == true){
				System.out.println("Status: Ativo");
			} else {
				System.out.println("Status: Bloqueado");
			}
			
			System.out.println("");
			
		}
		
	}
	
	@Test
	@Ignore
	public void buscar(){
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(1L);
		
		System.out.println("Usuario: " + usuario.getPessoa().getNome());
		System.out.println("Senha: " + usuario.getSenha());
		System.out.println("Tipo de Usuario: " + usuario.getTipo());
		
		if(usuario.getAtivo() == true){
			System.out.println("Status: Ativo");
		} else {
			System.out.println("Status: Bloqueado");
		}

	}
	
	@Test
	@Ignore
	public void excluir(){
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(5L);
		
		usuarioDAO.excluir(usuario);
		System.out.println("usuario excluido com sucesso!");
		
	}
	
	@Test
	@Ignore
	public void editar(){
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(4L);
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(4l);
		
		usuario.setPessoa(pessoa);
		usuario.setAtivo(true);
		usuario.setSenha("0012");
		usuario.setTipo('g');
		
		usuarioDAO.editar(usuario);
		
		System.out.println("usuario editado com sucesso!");
	}
	
}
