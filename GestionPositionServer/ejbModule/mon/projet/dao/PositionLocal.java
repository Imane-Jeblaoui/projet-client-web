package mon.projet.dao;

import java.util.List;

import javax.ejb.Local;

import mon.projet.entities.Position;

@Local
public interface PositionLocal {

	void create(Position p);

	void delteById(Position p);

	Position update(Position p);

	Position findById(int id);

	List<Position> findAll();
		
}
