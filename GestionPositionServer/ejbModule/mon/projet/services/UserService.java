package mon.projet.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import mon.projet.dao.UtilisateurLocal;
import mon.projet.dao.UtilisateurRemote;
import mon.projet.entities.User;

@Stateless
public class UserService implements UtilisateurRemote,UtilisateurLocal{
	
	@PersistenceContext(name = "GestionPositionServer")
	private EntityManager em;
	

	@Override
	public void create(User u) {
		em.persist(u);
	}

	@Override
	public void delteById(User u) {
		System.out.println("delete  "+u);
		em.remove(em.contains(u) ? u : em.merge(u));
		
	}

	@Override
	public User update(User u) {
		em.persist(em.contains(u) ? u: em.merge(u));
		return u;
	}

	@Override
	public User findById(int i) {
		return (User) em.find(User.class,i);
	}

	@Override
	public List<User> findAll() {
		Query query = em.createQuery("select u from users u");
		System.out.println(query.getResultList());
		System.out.println("hello");
		return query.getResultList();
		//return null;
	}


}
