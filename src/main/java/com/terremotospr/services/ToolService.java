package com.terremotospr.services;

import com.terremotospr.beans.ToolBean;
import com.terremotospr.database.entities.Tool;
import com.terremotospr.database.repositories.ToolRepository;
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
public class ToolService {

    @Autowired
    ToolRepository toolRepository;

    public List<ToolBean> fetchAllTool(){
        List<ToolBean> tools;

        Iterable<Tool> iter = toolRepository.findAll();

        tools = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return tools;
    }

    private ToolBean copyProperties(Tool entity){
        ToolBean bean = new ToolBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public boolean addTool(ToolBean bean) {
        if(bean == null) return false;

        Tool entity = new Tool();
        BeanUtils.copyProperties(bean, entity);
        toolRepository.save(entity);
        return true;
    }
}
