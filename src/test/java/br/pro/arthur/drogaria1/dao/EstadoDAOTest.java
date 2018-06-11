package br.pro.arthur.drogaria1.dao;

import java.util.List;

import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;

import br.pro.arthur.drogaria1.domain.Estado;
import br.pro.arthur.drogaria1.util.HibernateUtil;

@SuppressWarnings("unused")
public class EstadoDAOTest {

	
	@Test	
	
	public void salvar(){
		
		Estado estado = new Estado();
		
		estado.setNome("Para");
		estado.setSigla("PA");
		
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
	}
	
	@Test
	 @Ignore
	public void listar(){
		
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();
		
		for(Estado estado : resultado){
			
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
			
		}
	}
	
	@Ignore
	@Test
	public void buscar(){
		Long codigo = 2L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
	}
	

	@Test 
	@Ignore
	public void excluir(){
		Long codigo = 1L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado == null){
			System.out.println("Nenhum registro encontrado");
			
		}else{
			estadoDAO.excluir(estado);
			System.out.println("Registro removido:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}
	}
	
	@Ignore
	@Test
	public void editar(){
		Long codigo = 2L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			System.out.println("Registro editado - Antes:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
			
			estado.setNome("Pernambuco");
			estado.setSigla("PE");
			estadoDAO.editar(estado);
			
			System.out.println("Registro editado - Depois:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}
	}
	
	
	
	
	
	
	
}	
	
