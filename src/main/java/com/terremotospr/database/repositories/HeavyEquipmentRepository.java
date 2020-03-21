package com.terremotospr.database.repositories;

import com.terremotospr.database.entities.HeavyEquipment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/15/2020
 */

@Repository
public interface HeavyEquipmentRepository extends CrudRepository<HeavyEquipment,Long> {
}
