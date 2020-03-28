package com.terremotospr.beans.administrativeBeans;

/**
 * @author Kiara Rodriguez Rojas
 * date 03/15/2020
 */
public class CompanyBean{

    private Long comp_id;
    private String cName;
    private String cLocation;

    public Long getComp_id() { return comp_id; }

    public void setComp_id(Long comp_id) { this.comp_id = comp_id; }

    public String getcName() { return cName; }

    public void setcName(String cName) { this.cName = cName; }

    public String getcLocation() { return cLocation; }

    public void setcLocation(String cLocation) { this.cLocation = cLocation; }

//    public List<SupplierBean> getSuppliers() {
//        return suppliers;
//    }
//
//    public void setSuppliers(List<SupplierBean> suppliers) {
//        this.suppliers = suppliers;
//    }
//
//    private List<SupplierBean> suppliers;
}