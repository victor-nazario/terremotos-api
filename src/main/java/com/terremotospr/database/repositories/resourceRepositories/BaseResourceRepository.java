package com.terremotospr.database.repositories.resourceRepositories;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.terremotospr.beans.resourceBeans.FuelTypeGenerator;
import com.terremotospr.beans.resourceBeans.PowerGeneratorType;
import com.terremotospr.database.entities.resourceEntities.BaseResource;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/*
 * @author Wilfredo Aponte Pomales
 */
@Repository
public interface BaseResourceRepository extends CrudRepository<BaseResource, Long> {
        @Query(value = "SELECT * FROM base_resource", nativeQuery = true)
        List<BaseResource> findAllResources();

        @Query(value = "SELECT * FROM base_resource where id = :id", nativeQuery = true)
        Optional<BaseResource> findResourceById(Long id);

        List<BaseResource> findAllByAvailableIsTrueOrderByName();

        List<BaseResource> findAllByNameEquals(String name);

        Long countAllByAvailable(boolean available);

        @Modifying
        @Query(value = "insert into base_resource (available, brand, category, description, expiration_date, " +
                "latitude, longitude, name, price) values (:available, :brand, :category, :description, :expiration_date," +
                ":latitude, :longitude, :name, :price)",
                nativeQuery = true)
        void insertResource(@Param("available") boolean available, @Param("brand") String brand,
                            @Param("description") String description,
                            @Param("expiration_date") Date expiration_date, @Param("latitude") Double latitude,
                            @Param("longitude") Double longitude, @Param("price") Double price,
                            @Param("name") String name, @Param("category") String category);

}
