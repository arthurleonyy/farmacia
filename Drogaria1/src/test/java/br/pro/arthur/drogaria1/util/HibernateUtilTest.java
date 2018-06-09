package br.pro.arthur.drogaria1.util;

import org.hibernate.Session;
import org.junit.Test;

public class HibernateUtilTest {
	
	/*ANUNCIANDO QUE O METODO É DE TESTE*/
	@Test 
	public void conectar(){
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();
	}

}
