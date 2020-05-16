package com.terremotospr.database.repositories.resourceRepositories;

import com.terremotospr.database.entities.resourceEntities.Tool;
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
public interface ToolRepository extends CrudRepository<Tool, Long> {
    @Query(value = "select * from tool t inner join base_resource br on t.id = br.id", nativeQuery = true)
    List<Tool> findAll();

    @Query(value = "select * from tool t inner join base_resource br on t.id = br.id where t.id = :id"
            , nativeQuery = true)
    Tool findById(@Param("id") Integer id);

    @Query(value = "select * from tool t  inner join base_resource br on t.id = br.id where br.name = :name"
            , nativeQuery = true)
    List<Tool> findByName(@Param("name") String name);

    @Query(value = "select * from tool t  inner join base_resource br on t.id = br.id where br.available = true"
            , nativeQuery = true)
    List<Tool> findAvailable();

    @Modifying
    @Query(value = "insert into tool (type, weight, id) values (:type, :weight, :id)",
            nativeQuery = true)
    void insertTool(@Param("type") String type, @Param("weight") Double weight,
                        @Param("id") Long id);

}
