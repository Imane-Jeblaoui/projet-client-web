package mon.projet.dao;

import java.util.List; 

import javax.ejb.Remote;

import mon.projet.entities.SmartPhone;

@Remote
public interface SmartphoneRemote {

	void create(SmartPhone s);

	void delteById(SmartPhone s);

	SmartPhone update(SmartPhone s);

	SmartPhone findById(int id);

	List<SmartPhone> findAll();
	
}
