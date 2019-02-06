package nl.iprwc.persistence;

import io.dropwizard.hibernate.AbstractDAO;
import nl.iprwc.model.Deliver;
import org.hibernate.SessionFactory;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
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

    @SuppressWarnings("unchecked")
    public Deliver findByKey(String accountEmail, int productId) {
        Query query = currentSession().createQuery("from Deliver where accountEmail = :accountEmail and productId = :productId");
        query.setParameter("accountEmail", accountEmail);
        query.setParameter("productId", productId);
        try {
            return (Deliver)query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
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

    public List<Deliver> merge(List<Deliver> newDeliveries) {
        List<Deliver> updatedDeliveries = new ArrayList<>();
        for (Deliver newDelivery : newDeliveries) {
            String email = newDelivery.getAccountEmail();
            int id = newDelivery.getProductId();
            Deliver oldDelivery = findByKey(email, id);
            if (oldDelivery == null) {
                insert(newDelivery);
                updatedDeliveries.add(newDelivery);
            } else {
                oldDelivery.setAmount(oldDelivery.getAmount() + newDelivery.getAmount());
                update(oldDelivery);
                updatedDeliveries.add(oldDelivery);
            }
        }
        return updatedDeliveries;
    }

}



