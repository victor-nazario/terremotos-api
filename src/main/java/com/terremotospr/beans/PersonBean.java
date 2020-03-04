package com.terremotospr.beans;

/**
 * Created on March 3, 2020 - 6:33PM
 *
 * @author Victor Nazario
 */
public class PersonBean {
    Long id;
    String firstName;
    String lastName;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }
}
