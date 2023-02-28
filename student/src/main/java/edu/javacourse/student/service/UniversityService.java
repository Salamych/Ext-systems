package edu.javacourse.student.service;

import edu.javacourse.student.dao.FacultyRepository;
import edu.javacourse.student.dao.UniversityRepository;
import edu.javacourse.student.domain.Faculty;
import edu.javacourse.student.domain.University;
import java.util.List;
import java.util.Optional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UniversityService {

    @Autowired
    private UniversityRepository universityRepository;
    @Autowired
    private FacultyRepository facultyRepository;
    
    @Transactional(readOnly = true)
    public List<University> findUniversities() {
        return universityRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public List<University> findFullUniversities(){
    return universityRepository.findFullList();
    }
    
    @Transactional(readOnly = true)
    public List<Faculty> findFaculties(){
    return facultyRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    public University gerUniversity(Long universityId){
    Optional<University> uop = universityRepository.findById(universityId);
    University uc = uop.get();
    Hibernate.initialize(uc.getFaculties());
    return uc;
    }
    
    @Transactional(readOnly = true)
    public Faculty getFaculty(Long facultyId){
        Optional<Faculty> fop = facultyRepository.findById(facultyId);
        Faculty fc = fop.get();
        Hibernate.initialize(fc.getUniversity());
        return fc;
    }
}
