package org.launchcode.employee.models.forms;

import org.launchcode.employee.models.Employee;
import org.launchcode.employee.models.Skill;

import javax.validation.constraints.NotNull;

/**
 * Created by mkabd on 8/6/2017.
 */
public class AddSkillForm {

    private Employee employee;

    private Iterable<Skill> skills;

    @NotNull
    private int employeeId;

    @NotNull
    private int skillId;

    public AddSkillForm() {

    }

    public AddSkillForm(Employee employee, Iterable<Skill> skills) {
        this.employee = employee;
        this.skills = skills;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Iterable<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Iterable<Skill> skills) {
        this.skills = skills;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }
}
