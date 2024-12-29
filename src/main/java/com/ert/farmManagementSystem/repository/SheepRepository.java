package com.ert.farmManagementSystem.repository;

import com.ert.farmManagementSystem.config.HibernateUtils;
import com.ert.farmManagementSystem.domain.Cow;
import com.ert.farmManagementSystem.domain.Sheep;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SheepRepository {

    private Session session;

    public void save(Sheep sheep) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction trs = session.beginTransaction();
            session.save(sheep);
            trs.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }


    }

    public Sheep findById(Integer findId) {
        try {
            session = HibernateUtils.getSessionFactory().openSession();

            return session.get(Sheep.class, findId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }


    public void delete(Sheep deleteSheep) {

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction trs = session.beginTransaction();

            session.delete(deleteSheep);
            trs.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            HibernateUtils.closeSession(session);
        }

    }

    public List<Sheep> findAll() {
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            return session.createQuery("From Sheep", Sheep.class).getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }
        return null;
    }

    public void update(Sheep foundSheep) {

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            Transaction trs = session.beginTransaction();

            session.update(foundSheep);

            trs.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            HibernateUtils.closeSession(session);
        }
    }
}
