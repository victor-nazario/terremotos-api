package com.terremotospr.database.entities.administrativeEntities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created on March 17, 2020 - 12:56 AM
 *
 * @author Victor Nazario
 */
@Entity
public class Admin extends User {

    @JsonIgnore
    @OneToMany(targetEntity= Reserves.class, mappedBy="admin", cascade= CascadeType.ALL, orphanRemoval=true)
    private Set<Manages> manages = new HashSet<>();

    @ManyToMany
    private List<User> managedUsers;

    public Set<Manages> getManages() { return manages; }

    public void setManages(Set<Manages> manages) { this.manages = manages; }

    public List<User> getManagedUsers() {
        return managedUsers;
    }

    public void setManagedUsers(List<User> managedUsers) {
        this.managedUsers = managedUsers;
    }
}
