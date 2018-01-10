package org.launchcode.employee.models.data;

import org.launchcode.employee.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Created by mkabd on 1/1/2018.
 */
@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {




}
