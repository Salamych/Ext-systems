package edu.javacourse.register.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
@DiscriminatorValue("2")
public class PersonMale extends Person{
    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY,
        mappedBy = "husband")
    private List<MarriageCertificate> mariageCertificates;
    @OneToMany(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY,
        mappedBy = "father")
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
