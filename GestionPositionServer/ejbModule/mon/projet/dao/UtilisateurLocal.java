package mon.projet.dao;

import java.util.List; 

import javax.ejb.Local;

import mon.projet.entities.User;

@Local
public interface UtilisateurLocal {

	void create(User u);

	void delteById(User u);

	User update(User u);

	User findById(int id);

	List<User> findAll();
	
}
