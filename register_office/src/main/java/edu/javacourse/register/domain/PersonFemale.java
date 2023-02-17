package edu.javacourse.register.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
@DiscriminatorValue("1")
public class PersonFemale extends Person {
    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY,
        mappedBy = "wife")
    private List<MarriageCertificate> mariageCertificates;
    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY,
        mappedBy = "mother")
    private List<BirthCertificate> birthCertificates;

    public List<MarriageCertificate> getMariageCertificates() {
        return mariageCertificates;
    }

    public void setMariageCertificates(List<MarriageCertificate> mariageCertificates) {
        this.mariageCertificates = mariageCertificates;
    }

    public List<BirthCertificate> getBirthCertificates() {
        return birthCertificates;
    }

    public void setBirthCertificates(List<BirthCertificate> birthCertificates) {
        this.birthCertificates = birthCertificates;
    }
    
    
    
    
}
