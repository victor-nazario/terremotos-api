package com.terremotospr.database.repositories.administrativeRepositories;

import com.terremotospr.beans.administrativeBeans.AccountStatus;
import com.terremotospr.database.entities.administrativeEntities.Admin;
import com.terremotospr.database.entities.administrativeEntities.Manages;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/26/2020
 */
@Repository
public interface ManagesRepository extends CrudRepository<Manages, Long> {
    Set<Manages> findAllByAdminEquals(Admin admin);
    @Query(value = "select * from manages ma inner join admin a on ma.admin_id = a.id " +
            "inner join user u on ma.user_id = u.id", nativeQuery = true)
    List<Manages> findAll();

    @Query(value = "select * from manages ma inner join user u on ma.user_id = u.id " +
            "inner join admin a on ma.admin_id = a.id where ma.user_id = :userId", nativeQuery = true)
    List<Manages> findByUserId(@Param("userId") Integer userId);

    @Query(value = "select * from manages ma inner join user u on ma.user_id = u.id " +
            "inner join admin a on ma.admin_id = a.id where ma.admin_id = :adminId", nativeQuery = true)
    List<Manages> findByAdminId(@Param("adminId") Integer adminId);

    @Query(value = "select * from manages ma inner join user u on ma.user_id = u.id " +
            "inner join admin a on ma.admin_id = a.id where ma.status = :status", nativeQuery = true)
    List<Manages> findByAccountStatus(@Param("status") AccountStatus status);

    @Modifying
    @Query(value = "insert into manages (status, primary key(adminId, userId)) values (:status, (:adminId, :userId))",
            nativeQuery = true)
    void insertManages(@Param("status") String status, @Param("adminId") Long adminId,
                    @Param("userId") Long userId);

}
