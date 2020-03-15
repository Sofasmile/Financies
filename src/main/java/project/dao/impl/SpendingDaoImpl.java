package project.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.dao.SpendingDao;
import project.entity.Spending;
import project.util.HibernateUtil;

public class SpendingDaoImpl implements SpendingDao {

    @Override
    public Spending add(Spending spending) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(spending);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return spending;
    }

    @Override
    public List<Spending> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Spending", Spending.class).list();
        } catch (Exception e) {
            throw new RuntimeException("Can't get all from  SpendingDaoImpl");
        }
    }
}
