package com.terremotospr.database.repositories.paymentRepositories;

import com.terremotospr.database.entities.paymentEntities.Cash;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @author Wilfredo Aponte Pomales
 */
@Repository
public interface CashRepository extends CrudRepository<Cash, Long> {

    @Query(value = "select * from cash c inner join payment_method pm on c.pm_id = pm.pm_id", nativeQuery = true)
    List<Cash> findAll();

    @Query(value = "select * from cash c inner join payment_method pm on c.pm_id = pm.pm_id where c.pm_id = :pm_id", nativeQuery = true)
    Cash findByPmId(@Param("pm_id") Integer pm_id);


    @Modifying
    @Query(value = "insert into cash (amount_available, pm_id) values (:amountAvailable, :pm_id)",
            nativeQuery = true)
    void insertCash(@Param("amountAvailable") Long amountAvailable, @Param("pm_id") Long pm_id);
}
