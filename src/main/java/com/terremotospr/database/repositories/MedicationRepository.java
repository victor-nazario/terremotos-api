package com.terremotospr.database.repositories;

import com.terremotospr.database.entities.Medication;
import org.springframework.data.repository.CrudRepository;

/*
 * @author Wilfredo Aponte
*/

public interface MedicationRepository extends CrudRepository<Medication, Long> {
    
}
