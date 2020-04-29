package com.terremotospr.database.repositories.paymentRepositories;

import com.terremotospr.beans.paymentBeans.CardBean;
import com.terremotospr.database.entities.paymentEntities.Card;
import com.terremotospr.database.entities.paymentEntities.PaypalAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @author Wilfredo Aponte Pomales
 */
@Repository
public interface CardRepository extends CrudRepository<Card, Long> {
    @Query(value = "select * from card c inner join payment_method pm on c.id = pm.id where c.pm_id = :pm_id", nativeQuery = true)
    CardBean findByPmId(@Param("pm_id") Integer pm_id);
}
