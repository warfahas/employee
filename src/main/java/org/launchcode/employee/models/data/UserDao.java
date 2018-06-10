package org.launchcode.employee.models.data;

import org.launchcode.employee.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Created by mkabd on 1/1/2018.
 */
@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Long> {

   // @Query("SELECT user FROM User WHERE user.id = ?#{principal.id}")
    //Iterable<User> check();

    //@PostAuthorize("returnObject?.to?.id == principal.id || returnObject?.from?.id == principal.id")
    //User findOne(@Param("id") Long id);

    //User findByEmail(@Param("email") String email);

    User findByEmail(String email);









}
