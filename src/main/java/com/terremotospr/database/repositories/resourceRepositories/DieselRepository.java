package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.database.entities.resourceEntities.Diesel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
@Repository
public interface DieselRepository extends CrudRepository<Diesel, Long> {

    @Query(value = "select * from diesel d inner join base_resource br on d.id = br.id", nativeQuery = true)
    List<Diesel> findAll();

    @Query(value = "select * from diesel d inner join base_resource br on d.id = br.id where d.id = :id"
            , nativeQuery = true)
    Diesel findById(@Param("id") Integer id);

    @Query(value = "select * from diesel d inner join base_resource br on d.id = br.id where br.name = :name"
            , nativeQuery = true)
    List<Diesel> findByName(@Param("name") String name);

    @Query(value = "select * from diesel d inner join base_resource br on d.id = br.id where br.available = true"
            , nativeQuery = true)
    List<Diesel> findAvailable();

    @Query(value = "insert into diesel (f_id, size, id) values (:f_id, :size, :id)",
            nativeQuery = true)
    void insertDiesel(@Param("f_id") Long f_id,
                        @Param("size") Double size, @Param("id") Long id);

}
