package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.database.entities.resourceEntities.Medication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
 * @author Wilfredo Aponte
*/

@Repository
public interface MedicationRepository extends CrudRepository<Medication, Long> {
    
}
