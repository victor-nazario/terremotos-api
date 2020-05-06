package com.terremotospr.services.paymentServices;

import com.terremotospr.beans.paymentBeans.CashBean;
import com.terremotospr.database.entities.paymentEntities.Cash;
import com.terremotospr.database.entities.paymentEntities.PaypalAccount;
import com.terremotospr.database.repositories.paymentRepositories.CashRepository;
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
public class CashService {
    @Autowired
    CashRepository cashRepository;

    public Boolean addCash(CashBean bean){
        if(bean == null) return false;

        Cash entity = new Cash();
        BeanUtils.copyProperties(bean, entity);
        cashRepository.save(entity);
        return true;

    }

    public List<CashBean> fetchAllCash(){
        List<CashBean> cash;

        Iterable<Cash> iter = cashRepository.findAll();

        cash = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return cash;
    }

    private CashBean copyProperties(Cash entity){
        CashBean bean = new CashBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public Cash findById(Integer id) { return cashRepository.findByPmId(id); }
}
