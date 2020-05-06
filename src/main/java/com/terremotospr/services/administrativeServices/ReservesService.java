package com.terremotospr.services.administrativeServices;

import com.terremotospr.beans.administrativeBeans.ReservesBean;
import com.terremotospr.database.entities.administrativeEntities.Reserves;
import com.terremotospr.database.repositories.administrativeRepositories.ReservesRepository;
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
public class ReservesService {
    @Autowired
    ReservesRepository reservesRepository;

    public Boolean addReserves(ReservesBean bean) {
        if(bean == null) return false;

        Reserves entity = new Reserves();
        BeanUtils.copyProperties(bean, entity, "reservation", "resources");
        entity.setReservationId(bean.getReservationId());
        entity.setResourceId(bean.getResourceId());
        reservesRepository.save(entity);
        return true;
    }

    private ReservesBean copyProperties(Reserves entity){
        ReservesBean bean = new ReservesBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public List<ReservesBean> fetchAllReserves(){
        List<ReservesBean> reserves;
        Iterable<Reserves> iter = reservesRepository.findAll();

        reserves = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return reserves;
    }

    public List<ReservesBean> findByReservationId(Integer reservationId){
        List<ReservesBean> reserves;
        List<Reserves> iter = reservesRepository.findByReservationId(reservationId);

        reserves = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return reserves;
    }

    public List<ReservesBean> findByResourceId(Integer resourceId){
        List<ReservesBean> reserves;
        Iterable<Reserves> iter = reservesRepository.findByResourceId(resourceId);

        reserves = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return reserves;
    }

    public List<ReservesBean> findByReservedQuantityOver(Integer quantity){
        List<ReservesBean> reserves;
        Iterable<Reserves> iter = reservesRepository.findByReservedQuantityOver(quantity);

        reserves = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return reserves;
    }

    public List<ReservesBean> findByReservedQuantityUnder(Integer quantity){
        List<ReservesBean> reserves;
        Iterable<Reserves> iter = reservesRepository.findByReservedQuantityUnder(quantity);

        reserves = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return reserves;
    }

}
