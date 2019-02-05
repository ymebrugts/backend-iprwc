package nl.iprwc.persistence;

import io.dropwizard.hibernate.AbstractDAO;
import nl.iprwc.model.Location;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class LocationDAO extends AbstractDAO<Location> {

    public  LocationDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    /**
     * Method returns all employees stored in the database.
     *
     * @return list of all employees stored in the database
     */
    public List<Location> findAll() {
        CriteriaBuilder builder = currentSession().getCriteriaBuilder();
        CriteriaQuery<Location> criteria = builder.createQuery(Location.class);
        criteria.from(Location.class);
        return currentSession().createQuery(criteria).getResultList();
    }

    public Location findById(int id) {
        return currentSession().get(Location.class, id);
    }

    public void delete(Location location) {
        currentSession().delete(location);
    }

    public void update(Location location) {
        currentSession().saveOrUpdate(location);
    }

    public Location insert(Location location) {
        return persist(location);
    }

}


