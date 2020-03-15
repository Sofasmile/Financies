package project.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.dao.PriceDao;
import project.entity.Price;
import project.util.HibernateUtil;

public class PriceDaoImpl implements PriceDao {


    @Override
    public Price add(Price price) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(price);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return price;
    }

    @Override
    public List<Price> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Price", Price.class).list();
        } catch (Exception e) {
            throw new RuntimeException("Can't get all from  PriceDaoImpl");
        }
    }
}
