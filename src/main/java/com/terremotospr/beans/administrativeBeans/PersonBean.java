package com.terremotospr.beans.administrativeBeans;

/**
 * Created on March 3, 2020 - 6:33PM
 *
 * @author Victor Nazario
 */
public class PersonBean {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String region;


    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getRegion() { return region; }

    public void setRegion(String region) { this.region = region; }
}

