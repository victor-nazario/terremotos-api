package com.terremotospr.database.entities.resourceEntities;

import com.terremotospr.database.entities.resourceEntities.BaseResource;

import javax.persistence.Entity;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
@Entity
public class Fuel extends BaseResource {
    private String type;
    private Long rId;
}
