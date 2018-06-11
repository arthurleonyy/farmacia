package br.pro.arthur.drogaria1.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.hql.internal.ast.tree.RestrictableStatement;

import br.pro.arthur.drogaria1.util.HibernateUtil;

@SuppressWarnings({ "unchecked", "unused" })

// o java reconhece que eu vou receber alguma classe entidade
public class GenericDAO<Entidade> {
	
	// capturando a classe
	private Class<Entidade> classe;
	
	public GenericDAO(){
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	
	public void salvar(Entidade entidade){
		
		// abrindo uma sessão
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		// criando uma transação
		Transaction transacao = null;
		
		try{
			// anunciando que  codigo abaixo é uma transação 
			// e se ocorrer algum erro ele desfaz o que ja foi feito
			transacao = sessao.beginTransaction();
			
			// salvando a sessão passanto um parametro generico
			sessao.save(entidade);
			
			// confirmando a transação
			transacao.commit();
			
		  // o hibernate usa exerções de tempo de execulsão
		} catch(RuntimeException erro){
			
			if(transacao != null){		
				transacao.rollback();
			}			
			System.out.println(erro);
			throw erro;
			
		}finally{
			sessao.close();
		}
		
	}
	
	public void excluir(Entidade entidade){
			
			Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
			Transaction transacao = null;
			
			try{
				transacao = sessao.beginTransaction();
				
				sessao.delete(entidade);
				
				transacao.commit();
				
			} catch(RuntimeException erro){
				
				if(transacao != null){		
					transacao.rollback();
				}			
				
				throw erro;
				
			}finally{
				sessao.close();
			}
			
		}
	
	public List<Entidade> listar(){
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try{
			Criteria consulta = sessao.createCriteria(classe);
			List<Entidade> resultado = consulta.list();
			
			return resultado;
			
		}catch(RuntimeException erro){
			throw erro;
			
		}finally{
			sessao.close();
		}
	
	}
	
		public Entidade buscar(Long codigo){
			
			Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
			
			try{				
				Criteria consulta = sessao.createCriteria(classe);
				consulta.add(Restrictions.idEq(codigo));
				
				Entidade resultado = (Entidade) consulta.uniqueResult();
				
				return resultado;
				
			}catch(RuntimeException erro){
				throw erro;
				
			}finally{
				sessao.close();
			}
		
		}
	
		public void editar(Entidade entidade){
				
				Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
			
				Transaction transacao = null;
				
				try{
					transacao = sessao.beginTransaction();
					
					sessao.update(entidade);
					
					transacao.commit();
					
				} catch(RuntimeException erro){
					
					if(transacao != null){		
						transacao.rollback();
					}			
					
					throw erro;
					
				}finally{
					sessao.close();
				}
				
			}
	
		
}
