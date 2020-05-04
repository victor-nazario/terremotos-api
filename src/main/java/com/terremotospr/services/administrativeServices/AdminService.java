package com.terremotospr.services.administrativeServices;

import com.terremotospr.beans.administrativeBeans.AdminBean;
import com.terremotospr.database.entities.administrativeEntities.Admin;
import com.terremotospr.database.repositories.administrativeRepositories.AdminRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created on March 17, 2020 - 12:59 AM
 *
 * @author Victor Nazario
 */

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public List<AdminBean> fetchAllAdmin(){
        List<AdminBean> admins;

        Iterable<Admin> iter = adminRepository.findAll();

        admins = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return admins;
    }

    public boolean addAdmin(AdminBean bean) {
        if(bean == null) return false;

        Admin entity = new Admin();
        BeanUtils.copyProperties(bean, entity);
        adminRepository.save(entity);
        return true;
    }



    private AdminBean copyProperties(Admin entity){
        AdminBean bean = new AdminBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public Admin findById(Long id){
        return adminRepository.findTheAdminId(id).get();
    }
}
