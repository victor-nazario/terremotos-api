package com.terremotospr.database.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created on March 13, 2020 - 9:43 PM
 *
 * @author Victor Nazario
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BaseResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;
    private String category;
    private String description;
    private boolean available;
    private Double price;
    private Double longitude;
    private Double latitude;
    @OneToMany(targetEntity=Supplies.class, mappedBy="resource", cascade=CascadeType.ALL, orphanRemoval=true)
    private Set<Supplies> supplies = new HashSet<>();

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date expirationDate;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getBrand() { return brand; }

    public void setBrand(String brand) { this.brand = brand; }

    public String getCategory() { return category; }

    public void setCategory(String resourceType) { this.category = resourceType; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public boolean isAvailable() { return available; }

    public void setAvailable(boolean available) { this.available = available; }

    public Double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }

    public Double getLongitude() { return longitude; }

    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public Double getLatitude() { return latitude; }

    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Date getExpirationDate() { return expirationDate; }

    public void setExpirationDate(Date expirationDate) { this.expirationDate = expirationDate; }

    public Set<Supplies> getSupplies() {
        return supplies;
    }

    public void setSupplies(Set<Supplies> supplies) {
        this.supplies = supplies;
    }
}
