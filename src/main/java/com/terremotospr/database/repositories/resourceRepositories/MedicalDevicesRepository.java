package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.beans.resourceBeans.ClothingBean;
import com.terremotospr.beans.resourceBeans.MedicalDevicesBean;
import com.terremotospr.beans.resourceBeans.medicalDeviceType;
import com.terremotospr.database.entities.resourceEntities.Clothing;
import com.terremotospr.database.entities.resourceEntities.MedicalDevices;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/*
 * @author Wilfredo Aponte Pomales
 */
@Repository
public interface MedicalDevicesRepository extends CrudRepository<MedicalDevices, Long> {
    @Query(value = "select * from medical_devices md inner join base_resource br on md.id = br.id", nativeQuery = true)
    List<MedicalDevices> findAll();

    @Query(value = "select * from medical_devices md inner join base_resource br on md.id = br.id where md.id = :id"
            , nativeQuery = true)
    MedicalDevices findById(@Param("id") Integer id);

    @Query(value = "select * from medical_devices md inner join base_resource br on md.id = br.id where br.price <= :price"
            , nativeQuery = true)
    List<MedicalDevices> findByPriceUnder(@Param("price") Double price);

    @Query(value = "select * from medical_devices md inner join base_resource br on md.id = br.id where br.brand = :brand"
            , nativeQuery = true)
    List<MedicalDevices> findByBrand(@Param("brand") String brand);

    @Query(value = "select * from medical_devices md inner join base_resource br on md.id = br.id where br.name = :name"
            , nativeQuery = true)
    List<MedicalDevices> findByName(@Param("name") String name);

    @Query(value = "select * from medical_devices md inner join base_resource br on md.id = br.id where br.available = true"
            , nativeQuery = true)
    List<MedicalDevices> findAvailable();

    @Query(value = "select * from medical_devices md inner join base_resource br on md.id = br.id where md.type = :type"
            , nativeQuery = true)
    List<MedicalDevices> findByType(@Param("type") medicalDeviceType type);
}
