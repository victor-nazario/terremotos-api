package com.terremotospr.services.paymentServices;

import com.terremotospr.beans.paymentBeans.PaymentBean;
import com.terremotospr.database.entities.paymentEntities.Payment;
import com.terremotospr.database.repositories.paymentRepositories.PaymentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author Kiara Rodriguez Rojas
 * @date 03/19/2020
 */
@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public Boolean addPayment(PaymentBean bean) {
        if(bean == null) return false;

        Payment entity = new Payment();
        BeanUtils.copyProperties(bean, entity, "consumer");
        entity.setConsumerId(bean.getConsumerId());
        paymentRepository.save(entity);
        return true;
    }

    private PaymentBean copyProperties(Payment entity){
        PaymentBean bean = new PaymentBean();
        BeanUtils.copyProperties(entity, bean);
        bean.setConsumerId(entity.getConsumer().getId());
        bean.setPayment_id(entity.getPaymentId());
        return bean;
    }

    public List<PaymentBean> fetchAllPayment(){
        List<PaymentBean> payments;
        Iterable<Payment> iter =  paymentRepository.findAll();

        payments = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return payments;
    }

    public Payment findPaymentById(Integer id){ return paymentRepository.findByPaymentId(id).get(); }

    public Payment findByConsumerId(Integer id){ return paymentRepository.findByConsumerId(id).get(); }

    public List<PaymentBean> findByAmountPaidOver(Double amountPaid){
        List<PaymentBean> payment;
        Iterable<Payment> iter = paymentRepository.findByAmountPaidOver(amountPaid);

        payment = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return payment;
    }
    public List<PaymentBean> findByAmountPaidUnder(Double amountPaid){
        List<PaymentBean> payment;
        Iterable<Payment> iter = paymentRepository.findByAmountPaidUnder(amountPaid);

        payment = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return payment;
    }
}
