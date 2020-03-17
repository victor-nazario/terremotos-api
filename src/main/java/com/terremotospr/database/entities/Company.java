package com.terremotospr.database.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */

@Entity(name = "Company")
public class Company {
    @Id
    @Column(name = "comp_id")
    private Long comp_id;
    private String cName;
    private String cLocation;


//    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "comp_id")
//    private List<Supplier> suppliers;

    public Long getComp_id() { return comp_id; }

    public void setComp_id(Long comp_id) { this.comp_id = comp_id; }

    public String getcName() { return cName; }

    public void setcName(String cName) { this.cName = cName; }

    public String getcLocation() { return cLocation; }

    public void setcLocation(String cLocation) { this.cLocation = cLocation; }

//    public List<Supplier> getSupplier() {
//        return suppliers;
//    }
//
//    public void setSupplier(List<Supplier> suppliers) {
//        this.suppliers = suppliers;
//    }
//
//    public void addSupplier(Supplier supplier) {
//        if (supplier != null) {
//            if (suppliers == null) {
//                suppliers = new ArrayList<>();
//            }
//        }
//        suppliers.add(supplier);
//        supplier.setCompany(this);
//    }
}
