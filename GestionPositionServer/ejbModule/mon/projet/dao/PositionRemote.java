package mon.projet.dao;

import java.util.List;

import javax.ejb.Remote;

import mon.projet.entities.Position;

@Remote
public interface PositionRemote {

	void create(Position p);

	void delteById(Position p);

	Position update(Position p);

	Position findById(int id);

	List<Position> findAll();
	
}
