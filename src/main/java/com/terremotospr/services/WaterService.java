package com.terremotospr.services;

import com.terremotospr.beans.WaterBean;
import com.terremotospr.database.entities.Water;
import com.terremotospr.database.repositories.WaterRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created on 12 March, 2020 - 9:20 PM
 *
 * @author Victor Nazario
 */

@Service
public class WaterService {

    @Autowired
    WaterRepository waterRepository;

    public List<WaterBean> fetchAllWater(){
      List<WaterBean> waters;

      Iterable<Water> iter = waterRepository.findAll();

      waters = StreamSupport.stream(iter.spliterator(), false)
              .map(this::copyProperties)
              .collect(Collectors.toList());

      return waters;
    }

    private WaterBean copyProperties(Water entity){
        WaterBean bean = new WaterBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

}
