package com.terremotospr.database.entities;

import javax.persistence.*;

/**
 * Created on March 13, 2020 - 9:43 PM
 *
 * @author Victor Nazario
 */
@MappedSuperclass
public class BaseResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String resourceType;
    private String description;
    private boolean available;
    private Double price;
    private Double longitude;
    private Double latitude;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getResourceType() { return resourceType; }

    public void setResourceType(String resourceType) { this.resourceType = resourceType; }

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
}
