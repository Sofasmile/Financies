package project.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.dao.IncomeDao;
import project.entity.Income;
import project.util.HibernateUtil;

public class IncomeDaoImpl implements IncomeDao {

    @Override
    public Income add(Income income) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(income);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return income;
    }

    @Override
    public List<Income> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Income", Income.class).list();
        } catch (Exception e) {
            throw new RuntimeException("Can't get all from  IncomeDaoImpl");
        }
    }
}
