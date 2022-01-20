package mon.projet.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import mon.projet.dao.SmartphoneLocal;
import mon.projet.dao.SmartphoneRemote;
import mon.projet.entities.SmartPhone;

@Stateless(name = "Smartphone")
public class SmartphoneService implements SmartphoneRemote, SmartphoneLocal {

	@PersistenceContext(name = "GestionPositionServer")
	private EntityManager em;

	@Override
	public void create(SmartPhone s) {
		System.out.println(s);
		em.merge(s);
	}

	@Override
	public void delteById(SmartPhone s) {
		em.remove(em.contains(s) ? s : em.merge(s));

	}

	@Override
	public SmartPhone update(SmartPhone s) {
		em.merge(em.contains(s) ? s : em.merge(s));
		return s;
	}

	@Override
	public SmartPhone findById(int s) {

		return em.find(SmartPhone.class, s);
	}

	@Override
	public List<SmartPhone> findAll() {
		Query q = em.createQuery("from SmartPhone");
		return q.getResultList();
	}

	@Override
	public SmartPhone findByEmei(String imei) {
		Query q = em.createQuery("select s from SmartPhone s where imei like :x");
		q.setParameter("x", imei);

		try {
			SmartPhone s = (SmartPhone) q.getResultList().get(0);
			return s;
		} catch (Exception e) {
			System.out.println(e);
		}
		return new SmartPhone();
	}
}
