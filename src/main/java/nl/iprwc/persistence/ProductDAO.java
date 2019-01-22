package nl.iprwc.persistence;
import io.dropwizard.hibernate.AbstractDAO;
import io.dropwizard.hibernate.SessionFactoryFactory;
import nl.iprwc.model.Product;
import nl.iprwc.util.DatabaseConnection;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends AbstractDAO<Product> {

    public ProductDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    /**
     * Method returns all employees stored in the database.
     *
     * @return list of all employees stored in the database
     */
    public List<Product> findAll() {
        CriteriaBuilder builder = currentSession().getCriteriaBuilder();
        CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
        criteria.from(Product.class);
        return currentSession().createQuery(criteria).getResultList();
    }

    public Product findById(int id) {
        return currentSession().get(Product.class, id);
    }

    public void delete(Product product) {
        currentSession().delete(product);
    }

    public void update(Product product) {
        currentSession().saveOrUpdate(product);
    }

    public Product insert(Product product) {
        return persist(product);
    }

}

