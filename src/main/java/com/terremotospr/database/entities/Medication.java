package com.terremotospr.database.entities;

import javax.persistence.Entity;

/*
 * @author Wilfredo Aponte
 */



@Entity(name = "Medication")
public class Medication extends BaseResource {

//    private Long id;
    private String medType;
    private Long size;
    private String dosageForm;

//    public Long getId() { return id; }
//
//    public void setId(Long id) { this.id = id; }

    public String getMedType() { return medType; }

    public void setMedType(String medType) { this.medType = medType; }

    public Long getSize() { return size; }

    public void setSize(Long size) { this.size = size; }

    public String getDosageForm() { return dosageForm; }

    public void setDosageForm(String dosageForm) { this.dosageForm = dosageForm; }

}
