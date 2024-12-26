package com.ert.farmManagementSystem.repository;

import com.ert.farmManagementSystem.config.HibernateUtils;
import com.ert.farmManagementSystem.domain.Cow;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CowRepository {

    private Session session;

    public void save(Cow cow) {

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction trs = session.beginTransaction();
            session.save(cow);
            trs.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }


    }

    public Cow findById(Integer id) {

        try {
            session = HibernateUtils.getSessionFactory().openSession();

            return session.get(Cow.class, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

    public void delete(Cow deleteCow) {

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction trs = session.beginTransaction();

            session.delete(deleteCow);
            trs.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }

    }

    public List<Cow> findAll() {

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            return session.createQuery("From Cow", Cow.class).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }
return null;
    }
}

