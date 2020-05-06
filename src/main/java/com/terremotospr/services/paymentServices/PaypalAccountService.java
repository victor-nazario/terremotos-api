package com.terremotospr.services.paymentServices;

import com.terremotospr.beans.paymentBeans.PaypalAccountBean;
import com.terremotospr.database.entities.paymentEntities.PaypalAccount;
import com.terremotospr.database.repositories.paymentRepositories.PaypalAccountRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/*
 * @author Wilfredo Aponte Pomales
 */
@Service
public class PaypalAccountService {

    @Autowired
    PaypalAccountRepository paypalAccountRepository;

    public Boolean addPaypalAccount(PaypalAccountBean bean){
        if(bean == null) return false;

        PaypalAccount entity = new PaypalAccount();
        BeanUtils.copyProperties(bean, entity);
        paypalAccountRepository.save(entity);
        return true;

    }

    public List<PaypalAccountBean> fetchAllPaypalAccount(){
        List<PaypalAccountBean> paypalAccount;

        Iterable<PaypalAccount> iter = paypalAccountRepository.findAll();

        paypalAccount = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return paypalAccount;
    }

    private PaypalAccountBean copyProperties(PaypalAccount entity){
        PaypalAccountBean bean = new PaypalAccountBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public List<PaypalAccountBean> findByPmId(Integer id){
        List<PaypalAccountBean> paypalAccount;

        Iterable<PaypalAccount> iter = paypalAccountRepository.findByPmId(id);

        paypalAccount = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return paypalAccount;
    }

    public PaypalAccount findById(Integer id) { return paypalAccountRepository.findById(id); }


}
