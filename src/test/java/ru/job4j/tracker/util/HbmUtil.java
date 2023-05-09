package ru.job4j.tracker.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HbmUtil {

    private static final StandardServiceRegistry REGISTRY = new StandardServiceRegistryBuilder().configure().build();
    private static final SessionFactory SF = new MetadataSources(REGISTRY).buildMetadata().buildSessionFactory();

    public static void clearDataBase() {
        final Session session = SF.openSession();
        try {
            session.beginTransaction();
            session.createQuery("DELETE FROM Item as i WHERE i.id > 0").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
            StandardServiceRegistryBuilder.destroy(REGISTRY);
        }
    }
}
