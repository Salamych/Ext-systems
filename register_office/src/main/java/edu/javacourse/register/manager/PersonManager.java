
package edu.javacourse.register.manager;

import edu.javacourse.register.domain.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class PersonManager {
    public static void main(String[] args) {
//        sessionExample();
        jpaExample();
    }

//    private static void sessionExample() throws HibernateException {
//        SessionFactory sf = buildSessionFactory();
//        
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        
//        Session session = sf.openSession();
//        
//        session.getTransaction().begin();
//        
//        Person p = new Person();
//        p.setFirstName("Василий");
//        p.setLastName("Сидоров");
//        
//        session.persist(p);
//        System.out.println(p.getPersonId());
//        
//   
//        
//        session.getTransaction().commit();
//        
//        session.close();
//        session = sf.openSession();
//        Person person = session.get(Person.class, p.getPersonId());
//        System.out.println(person);
//        session.close();
//        
//        session = sf.openSession();
//        
//        List<Person> list = session.createQuery("FROM Person", Person.class).list();
//        list.forEach(p1 -> System.out.println(p1));
//        
//        session.close();
//    }
    private static SessionFactory buildSessionFactory(){
    try {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(serviceRegistry)
                .getMetadataBuilder().build();
        return metadata.getSessionFactoryBuilder().build();
    }catch(Throwable ex){
    System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
    }
    }

    private static void jpaExample() {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("persistence");
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        Person p = new Person();
        p.setFirstName("Алексей");
        p.setLastName("Фёдоров");
        em.persist(p);
        System.out.println(p.getPersonId());
        
        em.getTransaction().commit();
        
        em = emf.createEntityManager();
        List list = em.createQuery("FROM Person").getResultList();
        list.forEach(p1 -> System.out.println(p1));
        
        em.close();
    }
}

























