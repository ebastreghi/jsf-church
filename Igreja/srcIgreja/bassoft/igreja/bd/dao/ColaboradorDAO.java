package bassoft.igreja.bd.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import bassoft.igreja.bd.entity.Colaborador;
import bassoft.igreja.bd.util.JPAUtil;

public class ColaboradorDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager em = JPAUtil.getEntityManagerByFacesContext();

	public void salvar(Colaborador colaborador){
		em.merge(colaborador);
	}
	
	public Colaborador getColaboradorById(Long id){
		return em.find(Colaborador.class, id);
	}
	
	public Colaborador getColaboradorCompletoById(Long id){
		TypedQuery<Colaborador> tq = em.createQuery("select c from Colaborador c join fetch c.igreja join fetch c.ministerios where c.id = :id", Colaborador.class);
		tq.setParameter("id", id);
		Colaborador aux = tq.getSingleResult();
		return aux;
	}
	
	public void excluir(Colaborador colaborador){
		em.remove(colaborador);
	}

	public List<Colaborador> colaboradores(){
		TypedQuery<Colaborador> tq = em.createQuery("select c from Colaborador c order by c.nome", Colaborador.class);
		return tq.getResultList();
	}
	
	public List<Colaborador> colaboradoresesByMesAniversario(Integer mes){
		TypedQuery<Colaborador> tq = em.createQuery("select c from Colaborador c where MONTH(c.dataNascimento) = :mes order by c.nome", Colaborador.class);
		tq.setParameter("mes", mes);
		List<Colaborador> aux = tq.getResultList();
		return aux;
	}
	
	public List<Colaborador> listarColaboradoresComPaginacao(int first, int pageSize, Colaborador colaborador){
		if(colaborador.getNome() != null && !colaborador.getNome().isEmpty()){
			TypedQuery<Colaborador> tq = em.createQuery("select c from Colaborador c join fetch c.igreja join fetch c.ministerios where lower(c.nome) like :nome order by c.nome", Colaborador.class);
			tq.setParameter("nome","%" + colaborador.getNome().toLowerCase() + "%");
			tq.setFirstResult(first);
			tq.setMaxResults(pageSize);
			return tq.getResultList();
		}else{
			TypedQuery<Colaborador> tq = em.createQuery("select c from Colaborador c order by c.nome", Colaborador.class);
			tq.setFirstResult(first);
			tq.setMaxResults(pageSize);
			List<Colaborador> aux = tq.getResultList();
			return aux;
		}
	}
	
	public int countColaboradoresParaPaginacao(Colaborador colaborador){
		if(colaborador.getNome() != null && !colaborador.getNome().isEmpty()){
			Query q = em.createQuery("select count(c) from Colaborador c where lower(c.nome) like :nome");
			q.setParameter("nome","%" + colaborador.getNome().toLowerCase() + "%");
			Long count = (Long) q.getSingleResult();
			return (count.intValue());
		}else{
			Query q = em.createQuery("select count(c) from Colaborador c");
			Long count = (Long) q.getSingleResult();
			return (count.intValue());
		}
	}
}
