package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.database.entities.resourceEntities.Propane;
import org.springframework.data.jpa.repository.Modifying;
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
public interface PropaneRepository extends CrudRepository<Propane, Long> {
    @Query(value = "select * from propane pr inner join base_resource br on pr.id = br.id", nativeQuery = true)
    List<Propane> findAll();

    @Query(value = "select * from propane pr inner join base_resource br on pr.id = br.id where pr.id = :id"
            , nativeQuery = true)
    Propane findById(@Param("id") Integer id);

    @Query(value = "select * from propane pr inner join base_resource br on pr.id = br.id where br.name = :name"
            , nativeQuery = true)
    List<Propane> findByName(@Param("name") String name);

    @Query(value = "select * from propane pr inner join base_resource br on pr.id = br.id where br.available = true"
            , nativeQuery = true)
    List<Propane> findAvailable();

    @Modifying
    @Query(value = "insert into propane (f_id, size, id) values (:f_id, :size, :id)",
            nativeQuery = true)
    void insertPropane(@Param("f_id") Long f_id, @Param("size") Double size,
                        @Param("id") Long id);

}
