package project.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import project.dao.IndicatorDao;
import project.entity.Indicator;
import project.util.HibernateUtil;

public class IndicatorDaoImpl implements IndicatorDao {

    @Override
    public Indicator add(Indicator indicator) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(indicator);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return indicator;
    }

    @Override
    public List<Indicator> listIndicators() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Indicator", Indicator.class).list();
        } catch (Exception e) {
            throw new RuntimeException("Can't get all from  IndicatorDaoImpl");
        }
    }
}
