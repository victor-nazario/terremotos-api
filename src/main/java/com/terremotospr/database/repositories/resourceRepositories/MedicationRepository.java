package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.beans.resourceBeans.ClothesGender;
import com.terremotospr.beans.resourceBeans.ClothingType;
import com.terremotospr.beans.resourceBeans.MedicationBean;
import com.terremotospr.database.entities.resourceEntities.DryFood;
import com.terremotospr.database.entities.resourceEntities.Medication;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @author Wilfredo Aponte
*/

@Repository
public interface MedicationRepository extends CrudRepository<Medication, Long> {

    @Query(value = "select * from medication m inner join base_resource br on m.id = br.id", nativeQuery = true)
    List<Medication> findAll();

    @Query(value = "select * from medication m inner join base_resource br on m.id = br.id where m.id = :id"
            , nativeQuery = true)
    Medication findById(@Param("id") Integer id);

    @Query(value = "select * from medication m inner join base_resource br on m.id = br.id where br.price <= :price"
            , nativeQuery = true)
    List<Medication> findByPriceUnder(@Param("price") Double price);

    @Query(value = "select * from medication m inner join base_resource br on m.id = br.id where br.brand = :brand"
            , nativeQuery = true)
    List<Medication> findByBrand(@Param("brand") String brand);

    @Query(value = "select * from medication m inner join base_resource br on m.id = br.id where br.name = :name"
            , nativeQuery = true)
    List<Medication> findByName(@Param("name") String name);

    @Query(value = "select * from medication m inner join base_resource br on m.id = br.id where m.size = :size"
            , nativeQuery = true)
    List<Medication> findBySize(@Param("size") String size);

    @Query(value = "select * from medication m inner join base_resource br on m.id = br.id where br.available = true"
            , nativeQuery = true)
    List<Medication> findAvailable();

    @Modifying
    @Query(value = "insert into medication (size, med_type, dosage_form, id) values (:size, :med_type, :dosage_form, :material, :id)",
            nativeQuery = true)
    void insertMedication(@Param("size") Double size, @Param("med_type") String med_type,
                          @Param("dosage_form") String dosage_form, @Param("id") Long id);
}
