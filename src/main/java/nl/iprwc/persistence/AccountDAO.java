package nl.iprwc.persistence;
import io.dropwizard.hibernate.AbstractDAO;
import nl.iprwc.model.Account;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class AccountDAO extends AbstractDAO<Account> {

    public AccountDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    /**
     * Method returns all employees stored in the database.
     *
     * @return list of all employees stored in the database
     */
    public List<Account> findAll() {
        CriteriaBuilder builder = currentSession().getCriteriaBuilder();
        CriteriaQuery<Account> criteria = builder.createQuery(Account.class);
        criteria.from(Account.class);
        return currentSession().createQuery(criteria).getResultList();
    }

    public Account findByEmail(String email) {
        return currentSession().get(Account.class, email);
    }

    public void delete(Account account) {
        currentSession().delete(account);
    }

    public void update(Account account) {
        currentSession().saveOrUpdate(account);
    }

    public Account insert(Account account) {
        return persist(account);
    }

}

