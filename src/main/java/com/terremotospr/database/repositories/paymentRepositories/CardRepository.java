package com.terremotospr.database.repositories.paymentRepositories;

import com.terremotospr.database.entities.paymentEntities.Card;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/*
 * @author Wilfredo Aponte Pomales
 */
@Repository
public interface CardRepository extends CrudRepository<Card, Long> {

    @Query(value = "select * from card c inner join payment_method pm on c.pm_id = pm.pm_id", nativeQuery = true)
    List<Card> findAll();

    @Query(value = "select * from card c inner join payment_method pm on c.pm_id = pm.pm_id where c.pm_id = :pm_id", nativeQuery = true)
    Card findByPmId(@Param("pm_id") Integer pm_id);

    @Modifying
    @Query(value = "insert into card (expiration_date, card_number, pm_id) values (:expirationDate, :cardNumber, :pm_id)",
            nativeQuery = true)
    void insertCard(@Param("expirationDate") Date expirationDate, @Param("cardNumber") Long cardNumber,
                        @Param("pm_id") Long pm_id);
}
