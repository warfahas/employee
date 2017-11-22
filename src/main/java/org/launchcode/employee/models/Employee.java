package org.launchcode.employee.models;

import org.hibernate.annotations.*;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Sort;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * Created by mkabd on 7/8/2017.
 */
@Entity
public class Employee implements Comparable<Employee> {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Email
    private String email;

    @ManyToMany
    private List<Skill> skills;





    public Employee() {

    }

    public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Skill> getSkills() {
        return skills;
    }



    public void addItem(Skill item) {
        skills.add(item);
    }
    public void deleteItem(Skill item) {
        skills.remove(item);
    }
    @Override
    public int compareTo(Employee employee) {
        int compare = lastName.compareTo(employee.lastName);
        if (compare == 0) {
            compare = firstName.compareTo(employee.firstName);
        }
        return compare;
    }
}
