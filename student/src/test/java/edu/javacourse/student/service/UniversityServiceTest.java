package edu.javacourse.student.service;

import edu.javacourse.student.domain.Faculty;
import edu.javacourse.student.domain.University;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath:springContext.xml"})
public class UniversityServiceTest {
    
@Autowired
private UniversityService service;
    
    @Test
    public void findUniversities() {
        List<University> list = service.findUniversities();
        System.out.println("Ok");
        list.forEach(u -> System.out.println(
                u.getUniversityId() + " : "+u.getUniversityName()));
        
    }
    
    @Test
    public void findFullUniversities() {
        List<University> list = service.findFullUniversities();
        System.out.println("Ok");
        list.forEach(u -> System.out.println(
                u.getUniversityId() + " : "+u.getUniversityName() + " : " + u.getFaculties().size()));
        
    }
    
    @Test
    public void getUniversity(){
    University u = service.gerUniversity(1L);
        System.out.println(u.getUniversityName()+" : "+u.getFaculties().size());
    }
    

    
    @Test
    public void getFaculty(){
    Faculty faculty = service.getFaculty(1L);
        System.out.println(faculty.getUniversity().getUniversityName());
    }
}
