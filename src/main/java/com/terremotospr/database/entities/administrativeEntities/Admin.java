package com.terremotospr.database.entities.administrativeEntities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created on March 17, 2020 - 12:56 AM
 *
 * @author Victor Nazario
 */
@Entity
public class Admin extends User {

    @OneToMany(targetEntity= Reserves.class, mappedBy="admin", cascade= CascadeType.ALL, orphanRemoval=true)
    private Set<Manages> manages = new HashSet<>();

    public Set<Manages> getManages() { return manages; }

    public void setManages(Set<Manages> manages) { this.manages = manages; }
}
