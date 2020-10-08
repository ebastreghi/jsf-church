package bassoft.igreja.bd.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import bassoft.igreja.bd.entity.Igreja;
import bassoft.igreja.bd.util.JPAUtil;

public class IgrejaDAO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private EntityManager em = JPAUtil.getEntityManagerByFacesContext();
	
	public void salvar(Igreja igreja){
		em.persist(igreja);
	}

	public List<Igreja> listIgreja(){
		TypedQuery<Igreja> tq = em.createQuery("select i from Igreja i order by i.nome", Igreja.class);
		return tq.getResultList();
	}

	public void excluir(Igreja igreja){
		em.remove(igreja);
	}
	
	public Igreja getIgrejaById(Long id){
		return em.find(Igreja.class, id);
	}
}
