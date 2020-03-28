package com.terremotospr.services;

import com.terremotospr.beans.ReservationBean;
import com.terremotospr.database.entities.administrativeEntities.Reservation;
import com.terremotospr.database.repositories.administrativeRepositories.ReservationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */
@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public List<ReservationBean> fetchAllReservation(){
        List<ReservationBean> reservation;

        Iterable<Reservation> iter = reservationRepository.findAll();

        reservation = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return reservation;
    }

    private ReservationBean copyProperties(Reservation entity){
        ReservationBean bean = new ReservationBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public boolean addReservation(ReservationBean bean) {
        if(bean == null) return false;

        Reservation entity = new Reservation();
        BeanUtils.copyProperties(bean, entity);
        reservationRepository.save(entity);
        return true;
    }
}
