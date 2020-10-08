package bassoft.igreja.bd.util;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns="/*")
public class FilterJPATransaction implements Filter {

	private EntityManagerFactory emf;  
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		
		EntityManager em = emf.createEntityManager();  
		
        request.setAttribute("entityManager", em);
		request.setCharacterEncoding("UTF-8"); //para problemas com acentuação
		response.setCharacterEncoding("UTF-8");
		
		EntityTransaction tx = em.getTransaction();
		try {
			//Mensagem.seguranca(); //utilizado para segurança da aplicação
			tx.begin();
			chain.doFilter(request, response);  //dentro do try para capturar as exceções dos Beans
			tx.commit();
		} catch (Throwable e) {
			if(tx != null && tx.isActive()){
				tx.rollback();
				e.printStackTrace();
			}
		}finally{
			em.close();
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.emf = Persistence.createEntityManagerFactory("Igreja"); 
	}
	
	@Override
	public void destroy() {
		this.emf.close();
	}
	
}
