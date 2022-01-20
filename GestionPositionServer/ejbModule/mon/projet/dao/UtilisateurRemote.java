package mon.projet.dao;

import java.util.List;

import javax.ejb.Remote;

import mon.projet.entities.User;

@Remote
public interface UtilisateurRemote {

	void create(User u);

	void delteById(User u);

	User update(User u);

	User findById(int id);

	List<User> findAll();
	
}
