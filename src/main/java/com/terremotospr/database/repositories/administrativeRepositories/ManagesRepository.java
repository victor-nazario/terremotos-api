package com.terremotospr.database.repositories.administrativeRepositories;

import com.terremotospr.beans.administrativeBeans.AccountStatus;
import com.terremotospr.database.entities.administrativeEntities.Manages;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/26/2020
 */
@Repository
public interface ManagesRepository extends CrudRepository<Manages, Long> {
    @Query(value = "select * from manages ma inner join user u on ma.user_id = u.id " +
            "inner join admin a on ma.admin_id = a.id", nativeQuery = true)
    List<Manages> findAll();

    @Query(value = "select * from manages ma inner join user u on ma.user_id = u.id " +
            "inner join admin a on ma.admin_id = a.id where ma.user_id = :userId", nativeQuery = true)
    List<Manages> findByUserId(@Param("userId") Integer userId);

    @Query(value = "select * from manages ma inner join user u on ma.user_id = u.id " +
            "inner join admin a on ma.admin_id = a.id where ma.admin_id = :adminId", nativeQuery = true)
    List<Manages> findByAdminId(@Param("adminId") Integer adminId);

    @Query(value = "select * from manages ma inner join user u on ma.user_id = u.id " +
            "inner join admin a on ma.admin_id = a.id where ma.status = :status", nativeQuery = true)
    List<Manages> findByAccountStatus(@Param("adminId") AccountStatus status);

}
