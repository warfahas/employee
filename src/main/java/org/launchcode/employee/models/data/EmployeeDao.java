package org.launchcode.employee.models.data;

import org.hibernate.criterion.Order;
import org.launchcode.employee.models.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by mkabd on 7/18/2017.
 */
@Repository
@Transactional
public interface EmployeeDao extends CrudRepository<Employee, Integer> {



}
