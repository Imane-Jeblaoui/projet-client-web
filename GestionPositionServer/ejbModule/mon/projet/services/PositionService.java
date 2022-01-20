package mon.projet.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import mon.projet.dao.PositionLocal;
import mon.projet.dao.PositionRemote;
import mon.projet.entities.Position;

@Stateless
public class PositionService implements PositionRemote, PositionLocal{

	@PersistenceContext(name = "GestionPositionServer")
	private EntityManager em;
	
	@Override
	public void create(Position p) {
		System.out.println("position** " + p);
		em.merge(p);	
	}

	@Override
	public void delteById(Position p) {
		em.remove(em.contains(p) ? p : em.merge(p));		
	}

	@Override
	public Position update(Position p) {
		em.persist(em.contains(p) ? p: em.merge(p));
		return p;
	}

	@Override
	public Position findById(int id) {
		return (Position) em.find(Position.class, id);
	}

	@Override
	public List<Position> findAll() {
		Query q = em.createQuery("select p from positions p");
		//System.out.println("position-- "+ q.getResultList());
		return q.getResultList();
	}

}
