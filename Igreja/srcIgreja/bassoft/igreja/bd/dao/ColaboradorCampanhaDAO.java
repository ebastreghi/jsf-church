package bassoft.igreja.bd.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import bassoft.igreja.bd.entity.Campanha;
import bassoft.igreja.bd.entity.Colaborador;
import bassoft.igreja.bd.entity.ColaboradorCampanha;
import bassoft.igreja.bd.util.JPAUtil;

public class ColaboradorCampanhaDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager em = JPAUtil.getEntityManagerByFacesContext();
	
	public void salvar(ColaboradorCampanha cc){
		em.persist(cc);
	}
	
	public List<ColaboradorCampanha> listByColaboradorAndCampanha(Colaborador colaborador, Campanha campanha) throws Exception{
		String jpql = "select cc" +
				" from ColaboradorCampanha cc join fetch cc.colaborador cola join fetch cc.campanha camp" +
				" where 1=1";
		StringBuilder sb = new StringBuilder();
		sb.append(jpql);
		if(campanha != null && campanha.getIdCampanha() != null){
			sb.append(" and camp.id = ");
			sb.append(campanha.getIdCampanha());
		}
		if(colaborador != null && colaborador.getIdColaborador() != null){
			sb.append(" and cola.id = ");
			sb.append(colaborador.getIdColaborador());
		} 
		sb.append(" order by camp.nome, cola.nome");
		TypedQuery<ColaboradorCampanha> tq = em.createQuery(sb.toString(), ColaboradorCampanha.class);
		return tq.getResultList();
	}
	
	public Long countColaboradorAndCampanha(Colaborador colaborador, Campanha campanha){
		String jpql = "select count(cc)" +
				" from ColaboradorCampanha cc" +
				" where 1=1";
		StringBuilder sb = new StringBuilder();
		sb.append(jpql);
		if(campanha != null && campanha.getIdCampanha() != null){
			sb.append(" and cc.campanha.idCampanha = ");
			sb.append(campanha.getIdCampanha());
		}
		if(colaborador != null && colaborador.getIdColaborador() != null){
			sb.append(" and cc.colaborador.idColaborador = ");
			sb.append(colaborador.getIdColaborador());
		} 
		Query q = em.createQuery(sb.toString());
		return (Long) q.getSingleResult();
	}
	
	public ColaboradorCampanha getColaboradorCampanhaById(Long id){
		return em.find(ColaboradorCampanha.class, id);
	}
	
	public void excluir(ColaboradorCampanha cc){
		em.remove(cc);
	}
	
}
