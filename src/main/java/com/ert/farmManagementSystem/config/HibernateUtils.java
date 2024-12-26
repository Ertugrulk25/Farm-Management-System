package com.ert.farmManagementSystem.config;

import com.ert.farmManagementSystem.domain.Cow;
import com.ert.farmManagementSystem.domain.Sheep;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static SessionFactory sessionFactory;
    static {
try {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Cow.class).
                addAnnotatedClass(Sheep.class);
        sessionFactory= configuration.buildSessionFactory();
}catch (Exception e){
    System.out.println(e.getMessage());
}
}

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static void shutDown(){
        if (sessionFactory!=null && sessionFactory.isOpen()){
            getSessionFactory().close();
        }
    }
public static void closeSession(Session session){
        if (session != null && session.isOpen()){
            session.close();
        }
}
}
