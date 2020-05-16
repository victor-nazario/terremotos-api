package com.terremotospr.database.repositories.administrativeRepositories;

import com.terremotospr.database.entities.administrativeEntities.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Kiara Rodriguez Rojas
 * @date 05/04/2020
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAllByIdEquals(Long id);

    @Query(value = "SELECT * FROM user u;", nativeQuery = true)
    List<User> findAllUsers();

    @Query(value="SELECT * FROM user u WHERE u.id = :id", nativeQuery = true)
    Optional<User> findById(@Param("id") Integer id);

    @Query(value="SELECT * FROM user u WHERE u.email = :email", nativeQuery = true)
    List<User> findByEmail(@Param("email") String email);

    @Query(value="SELECT * FROM user u WHERE u.first_name = :firstName", nativeQuery = true)
    List<User> findByFirstName(@Param("firstName") String firstName);

    @Query(value="SELECT * FROM user u WHERE u.last_name = :lastName", nativeQuery = true)
    List<User> findByLastName(@Param("lastName") String lastName);

    @Query(value="SELECT * FROM user u WHERE u.city = :city", nativeQuery = true)
    List<User> findByCity(@Param("city") String city);

    @Query(value="SELECT * FROM user u WHERE u.country = :country", nativeQuery = true)
    List<User> findByCountry(@Param("country") String country);

    @Query(value="SELECT * FROM user u WHERE u.region = :region", nativeQuery = true)
    List<User> findByRegion(@Param("region") String region);

    @Modifying
    @Query(value = "insert into user (email, first_name, last_name, line1, line2, city, country, region, zip_code)" +
            " values (:email, :firstName, :lastName, :line1, :line2, :city, :country, :region, :zipcode)",
            nativeQuery = true)
    void insertUser(@Param("email") String email, @Param("firstName") String firstName,
                        @Param("lastName") String lastName,
                        @Param("line1") String line1, @Param("line2") String line2,
                        @Param("city") String city, @Param("country") String country,
                        @Param("region") String region, @Param("zipcode") String zipcode);

}
