package com.terremotospr.database.repositories;

import com.terremotospr.database.entities.Medication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
 * @author Wilfredo Aponte
*/

@Repository
public interface MedicationRepository extends CrudRepository<Medication, Long> {
    
}
