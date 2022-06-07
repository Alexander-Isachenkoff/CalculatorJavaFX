package ru.isachenkoff.calculator.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.isachenkoff.calculator.operations.CalculationResult;

public class HibernateUtil {
    
    private static final SessionFactory sessionFactory;
    
    static {
        sessionFactory = new Configuration().configure()
                .addAnnotatedClass(CalculationResult.class)
                .buildSessionFactory();
    }
    
    public static Session getSession() {
        return sessionFactory.openSession();
    }
}
