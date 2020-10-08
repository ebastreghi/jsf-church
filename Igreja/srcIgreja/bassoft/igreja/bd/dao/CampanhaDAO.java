package bassoft.igreja.bd.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import bassoft.igreja.bd.entity.Campanha;
import bassoft.igreja.bd.util.JPAUtil;

public class CampanhaDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager em = JPAUtil.getEntityManagerByFacesContext();
	
	public Campanha getCampanhaById(Long id){
		return em.find(Campanha.class, id);
	}
	
	public void salvar(Campanha campanha){
		em.persist(campanha);
	}
	
	public void excluir(Campanha campanha){
		em.remove(campanha);
	}
	
	public List<Campanha> listar(){
		TypedQuery<Campanha> tq = em.createQuery("select c from Campanha c order by c.nome",Campanha.class);
		return tq.getResultList();
	}
}
