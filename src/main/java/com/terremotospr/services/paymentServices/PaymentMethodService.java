package com.terremotospr.services.paymentServices;

import com.terremotospr.beans.paymentBeans.PaymentMethodBean;
import com.terremotospr.database.entities.paymentEntities.PaymentMethod;
import com.terremotospr.database.repositories.paymentRepositories.PaymentMethodRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/30/2020
 */
@Service
public class PaymentMethodService {

    @Autowired
    PaymentMethodRepository paymentMethodRepository;

    public List<PaymentMethodBean> fetchAllPaymentMethod(){
        List<PaymentMethodBean> paymentMethods;

        Iterable<PaymentMethod> iter = paymentMethodRepository.findAll();

        paymentMethods = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return paymentMethods;
    }

    public boolean addPaymentMethod(PaymentMethodBean bean) {
        if(bean == null) return false;

        PaymentMethod entity = new PaymentMethod();
        BeanUtils.copyProperties(bean, entity, "consumer");
        entity.setConsumerId(bean.getConsumerId());
        paymentMethodRepository.save(entity);
        return true;
    }



    private PaymentMethodBean copyProperties(PaymentMethod entity){
        PaymentMethodBean bean = new PaymentMethodBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public PaymentMethod findPaymentById(Integer id){ return paymentMethodRepository.findByPaymentMethodId(id).get(); }

    public PaymentMethod findByConsumerId(Integer id){ return paymentMethodRepository.findByConsumerId(id).get(); }

}
