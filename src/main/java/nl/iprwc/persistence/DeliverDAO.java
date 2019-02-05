package nl.iprwc.persistence;

import io.dropwizard.hibernate.AbstractDAO;
import nl.iprwc.model.Deliver;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class DeliverDAO extends AbstractDAO<Deliver> {

    public DeliverDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    /**
     * Method returns all employees stored in the database.
     *
     * @return list of all employees stored in the database
     */
    public List<Deliver> findAll() {
        CriteriaBuilder builder = currentSession().getCriteriaBuilder();
        CriteriaQuery<Deliver> criteria = builder.createQuery(Deliver.class);
        criteria.from(Deliver.class);
        return currentSession().createQuery(criteria).getResultList();
    }

    public Deliver findById(int id) {
        return currentSession().get(Deliver.class, id);
    }

    public void delete(Deliver deliver) {
        currentSession().delete(deliver);
    }

    public void update(Deliver deliver) {
        currentSession().saveOrUpdate(deliver);
    }

    public Deliver insert(Deliver deliver) {
        return persist(deliver);
    }

}



