package org.launchcode.employee.models.data;

import org.launchcode.employee.models.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by mkabd on 7/18/2017.
 */
@Repository
@Transactional
public interface SkillDao extends CrudRepository<Skill, Integer> {


}
