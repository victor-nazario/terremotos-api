package com.terremotospr.controllers.administrativeControllers;

import com.terremotospr.beans.administrativeBeans.UserBean;
import com.terremotospr.database.entities.administrativeEntities.User;
import com.terremotospr.services.administrativeServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kiara Rodriguez Rojas
 * @date 05/04/2020
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/add")
    public boolean add(@RequestBody UserBean bean) {
        return userService.addUser(bean);
    }

    @GetMapping(value = "/fetch")
    public List<UserBean> fetchAll(){
        return userService.fetchAllUser();
    }

    @GetMapping(value = "/{id}")
    public User findUserById(@PathVariable int id) {
        return userService.findUserById(id);
    }

    @GetMapping(value = "/email/{email}")
    public List<UserBean> findUserByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @GetMapping(value = "/firstName/{firstName}")
    public List<UserBean> findUserByFirstName(@PathVariable String firstName) {
        return userService.findByFirstName(firstName);
    }

    @GetMapping(value = "/lastName/{lastName}")
    public List<UserBean> findUserByLastName(@PathVariable String lastName) {
        return userService.findByFirstName(lastName);
    }

    @GetMapping(value = "/city/{city}")
    public List<UserBean> findUserByCity(@PathVariable String city) {
        return userService.findByCity(city);
    }

    @GetMapping(value = "/country/{country}")
    public List<UserBean> findUserByCountry(@PathVariable String country) {
        return userService.findByCountry(country);
    }

    @GetMapping(value = "/region/{region}")
    public List<UserBean> findUserByRegion(@PathVariable String region) {
        return userService.findByRegion(region);
    }

}
