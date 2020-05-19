package com.terremotospr.services.administrativeServices;

import com.terremotospr.beans.administrativeBeans.AdminBean;
import com.terremotospr.beans.administrativeBeans.UserBean;
import com.terremotospr.database.entities.administrativeEntities.Admin;
import com.terremotospr.database.entities.administrativeEntities.User;
import com.terremotospr.database.repositories.administrativeRepositories.AdminRepository;
import com.terremotospr.database.repositories.administrativeRepositories.ManagesRepository;
import com.terremotospr.database.repositories.administrativeRepositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
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

    @Autowired
    ManagesRepository managesRepository;

    @Autowired
    UserRepository userRepository;

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
        List<UserBean> userBeans = new LinkedList<>();
        AdminBean bean = new AdminBean();
        BeanUtils.copyProperties(entity, bean);
        UserBean userBean = new UserBean();
        for (User user : entity.getManagedUsers()) {
            userBean.setCity(user.getCity());
            userBean.setCountry(user.getCountry());
            userBean.setEmail(user.getEmail());
            userBean.setFirstName(user.getFirstName());
            userBean.setLastName(user.getLastName());
            userBean.setLine1(user.getLine1());
            userBean.setLine2(user.getLine2());
            userBean.setRegion(user.getRegion());
            userBean.setZipCode(user.getZipCode());
            userBean.setId(user.getId());
            userBeans.add(userBean);
        }
        bean.setManagedUsers(userBeans);
        return bean;
    }

    public AdminBean findById(Long id){
        Admin admin = adminRepository.findById(id).get();
        admin.setManages(managesRepository.findAllByAdminEquals(admin));
        admin.setManagedUsers(userRepository.findAllByIdEquals(id));
        admin.setManagedUsers(userRepository.findAllByIdEquals(id));
        admin.setManagedUsers(userRepository.findAllByIdEquals(id));
        return copyProperties(admin);
    }

    public Long countAllUsers(){ return adminRepository.count();}
}
