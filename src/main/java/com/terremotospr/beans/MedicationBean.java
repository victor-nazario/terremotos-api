package com.terremotospr.beans;

/*
 * @author Wilfredo Aponte Pomales
*/

public class MedicationBean extends BaseResourceBean {

    private Long id;
    private String medType;
    private Double size;
    private String dosageForm;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getMedType() { return medType; }

    public void setMedType(String medType) { this.medType = medType; }

    public Double getSize() { return size; }

    public void setSize(Double size) { this.size = size; }

    public String getDosageForm() { return dosageForm; }

    public void setDosageForm(String dosageForm) { this.dosageForm = dosageForm; }
}
