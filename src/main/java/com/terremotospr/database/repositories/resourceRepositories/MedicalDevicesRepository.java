package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.database.entities.resourceEntities.MedicalDevices;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
 * @author Wilfredo Aponte Pomales
 */
@Repository
public interface MedicalDevicesRepository extends CrudRepository<MedicalDevices, Long> {

}
