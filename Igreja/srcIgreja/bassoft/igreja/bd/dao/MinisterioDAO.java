package bassoft.igreja.bd.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import bassoft.igreja.bd.entity.Ministerio;
import bassoft.igreja.bd.util.JPAUtil;

public class MinisterioDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager em = JPAUtil.getEntityManagerByFacesContext();
	
	public Ministerio getMinisterioById(Long id){
		return em.find(Ministerio.class, id);
	}
	
	public Long countColaboradorLider(Long idColaboradorLider){
		Query q = em.createQuery("select count(m) from Ministerio m where m.colaboradorLider.idColaborador = :idcolaboradorlider");
		q.setParameter("idcolaboradorlider", idColaboradorLider);
		return (Long) q.getSingleResult();
	}
	
	public void salvar(Ministerio ministerio){
		em.persist(ministerio);
	}

	public void excluir(Ministerio ministerio){
		em.remove(ministerio);
	}
	
	public List<Ministerio> ministerios(){
		TypedQuery<Ministerio> tq = em.createQuery("select m from Ministerio m order by m.nome", Ministerio.class);
		return tq.getResultList();
	}
	
	/*@SuppressWarnings("unchecked")
	public List<Ministerio> ministeriosWithNomeLider() throws Exception{
		try {
			String jpql = "select m.id as mid, m.nome as mnome, m.idcolaboradorlider as midcolaboradorlider, c.nome as cnome " +
					      "from ministerio m join colaborador c " +
					      "on m.idcolaboradorlider = c.id order by m.nome";
			Query query = em.createNativeQuery(jpql);
			List<Object[]> result = query.getResultList();
			List<Ministerio> ministerios = new ArrayList<Ministerio>();
			for(Object[] row : result){
				Ministerio ministerioAux = new Ministerio();
				ministerioAux.setIdMinisterio(((BigInteger)row[0]).longValue());
				ministerioAux.setNome((String)row[1]);
				ministerioAux.setIdColaboradorLider(((BigInteger)row[2]).longValue());
				ministerioAux.setNomeLider((String)row[3]);
				ministerios.add(ministerioAux);
			}
			return ministerios;
		} catch (Exception e) {
			throw e;
		}
	}*/
}
