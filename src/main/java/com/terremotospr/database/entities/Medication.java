package com.terremotospr.database.entities;

import javax.persistence.Entity;

/*
 * @author Wilfredo Aponte
 */



@Entity(name = "Medication")
public class Medication extends BaseResource {

//    private Long id;
    private String medType;
    private Double size;
    private String dosageForm;

//    public Long getId() { return id; }
//
//    public void setId(Long id) { this.id = id; }

    public String getMedType() { return medType; }

    public void setMedType(String medType) { this.medType = medType; }

    public Double getSize() { return size; }

    public void setSize(Double size) { this.size = size; }

    public String getDosageForm() { return dosageForm; }

    public void setDosageForm(String dosageForm) { this.dosageForm = dosageForm; }

}
