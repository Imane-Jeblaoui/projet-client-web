package mon.projet.dao;

import java.util.List; 

import javax.ejb.Local;

import mon.projet.entities.SmartPhone;

@Local
public interface SmartphoneLocal {

	void create(SmartPhone s);

	void delteById(SmartPhone s);

	SmartPhone update(SmartPhone s);

	SmartPhone findById(int id);

	List<SmartPhone> findAll();
	
	
	SmartPhone findByEmei(String imei);
	
}
