package com.terremotospr.database.repositories.administrativeRepositories;

import com.terremotospr.database.entities.administrativeEntities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created on 04 May, 2020 - 14:48
 *
 * @author Victor Nazario Morales
 */
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAllByIdEquals(Long id);
}