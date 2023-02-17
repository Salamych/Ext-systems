package edu.javacourse.register.dao;

import edu.javacourse.register.domain.Person;
import edu.javacourse.register.domain.PersonFemale;
import edu.javacourse.register.domain.PersonMale;
import java.util.List;
import org.junit.Test;

public class PersonDaoTest {

    @Test
    public void findPersons() {
        PersonDao dao = new PersonDao();
        List<Person> persons = dao.findPersons();

        persons.forEach(p -> {
            System.out.println("Name: "+p.getFirstName());
            System.out.println("Class for sex: "+p.getClass().getName());
            System.out.println("Passports: "+p.getPassports().size());
            System.out.println("Birth: "+p.getBirthCertificate());
            if (p instanceof PersonMale) {
                System.out.println("Birth Cert: "+((PersonMale) p).getBirthCertificates());
                System.out.println("Marriage Cert: "+((PersonMale) p).getMariageCertificates());
            } else {
                System.out.println("Birth Cert: "+((PersonFemale) p).getBirthCertificates());
                System.out.println("Marriage Cert: "+((PersonFemale) p).getMariageCertificates());
            }
        });
    }

}
