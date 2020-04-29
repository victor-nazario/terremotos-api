package com.terremotospr.database.repositories.paymentRepositories;

import com.terremotospr.beans.paymentBeans.CashBean;
import com.terremotospr.database.entities.paymentEntities.Card;
import com.terremotospr.database.entities.paymentEntities.Cash;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/*
 * @author Wilfredo Aponte Pomales
 */
@Repository
public interface CashRepository extends CrudRepository<Cash, Long> {

    @Query(value = "select * from cash c inner join payment_method pm on c.id = pm.id where c.pm_id = :pm_id", nativeQuery = true)
    CashBean findByPmId(@Param("pm_id") Integer pm_id);

}
