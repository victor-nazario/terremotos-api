package com.terremotospr.services.administrativeServices;

import com.terremotospr.beans.administrativeBeans.UserBean;
import com.terremotospr.database.entities.administrativeEntities.User;
import com.terremotospr.database.repositories.administrativeRepositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author Kiara Rodriguez Rojas
 * @date 05/04/2020
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Boolean addUser(UserBean bean) {
        if(bean == null) return false;

        User entity = new User();
        BeanUtils.copyProperties(bean, entity);
        userRepository.save(entity);
        return true;
    }

    private UserBean copyProperties(User entity){
        UserBean bean = new UserBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }

    public List<UserBean> fetchAllUser(){
        List<UserBean> users;
        Iterable<User> iter = userRepository.findAll();

        users = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return users;
    }

    public User findUserById(Integer id){
        return userRepository.findById(id).get();
    }

    public List<UserBean> findByEmail(String email){
        List<UserBean> user;
        Iterable<User> iter = userRepository.findByEmail(email);

        user = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return user;
    }

    public List<UserBean> findByFirstName(String firstName){
        List<UserBean> user;
        Iterable<User> iter = userRepository.findByFirstName(firstName);

        user = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return user;
    }

    public List<UserBean> findByLastName(String lastName){
        List<UserBean> user;
        Iterable<User> iter = userRepository.findByLastName(lastName);

        user = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return user;
    }

    public List<UserBean> findByCity(String city){
        List<UserBean> user;
        Iterable<User> iter = userRepository.findByCity(city);

        user = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return user;
    }

    public List<UserBean> findByCountry(String country){
        List<UserBean> user;
        Iterable<User> iter = userRepository.findByCity(country);

        user = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return user;
    }

    public List<UserBean> findByRegion(String region){
        List<UserBean> user;
        Iterable<User> iter = userRepository.findByRegion(region);

        user = StreamSupport.stream(iter.spliterator(), false)
                .map(this::copyProperties)
                .collect(Collectors.toList());

        return user;
    }
}
