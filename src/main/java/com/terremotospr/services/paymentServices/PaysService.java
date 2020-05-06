package com.terremotospr.services.paymentServices;

import com.terremotospr.beans.administrativeBeans.SuppliesBean;
import com.terremotospr.beans.paymentBeans.PaysBean;
import com.terremotospr.database.entities.administrativeEntities.Supplies;
import com.terremotospr.database.entities.paymentEntities.Pays;
import com.terremotospr.database.repositories.paymentRepositories.PaysRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/20/2020
 */
@Service
public class PaysService {
    @Autowired
    PaysRepository paysRepository;

    public Boolean addPays(PaysBean bean) {
        if(bean == null) return false;

        Pays entity = new Pays();
        BeanUtils.copyProperties(bean, entity, "payment", "placedOrder");
        entity.setOrderId(bean.getOrderId());
        entity.setPaymentId(bean.getPaymentId());
        paysRepository.save(entity);
        return true;
    }

    private PaysBean copyProperties(Pays entity){
        PaysBean bean = new PaysBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public List<PaysBean> fetchAllPays(){
        List<PaysBean> pays;
        Iterable<Pays> iter = paysRepository.findAll();

        pays = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return pays;
    }

    public List<PaysBean> findByPaymentId(Integer paymentId){
        List<PaysBean> pays;
        Iterable<Pays> iter = paysRepository.findByPaymentId(paymentId);

        pays = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return pays;
    }

    public List<PaysBean> findByPlacedOrderId(Integer orderId){
        List<PaysBean> pays;
        Iterable<Pays> iter = paysRepository.findByOrderId(orderId);

        pays = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return pays;
    }

}
