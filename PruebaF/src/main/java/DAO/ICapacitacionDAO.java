package DAO;
import java.util.List;
import Model.Capacitacion;
public interface ICapacitacionDAO {
public void create(Capacitacion c);
public List<Capacitacion>readAll();
public Capacitacion readOne(int id);

public void delete(int id);
public void delete (Capacitacion c);
public void update (Capacitacion c);
void updatde(Capacitacion c);

	

}
