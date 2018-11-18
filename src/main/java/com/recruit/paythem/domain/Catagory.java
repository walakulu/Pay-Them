package com.recruit.paythem.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * This Catagory class use for the persist employee categories.
 *
 */
@Entity
public class Catagory implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String type;

    //bi-directional many-to-one association to Employee
    @OneToMany(mappedBy="catagory")
    private List<Employee> employees;

    //bi-directional many-to-one association to Recruitment
    @OneToMany(mappedBy="catagory")
    private List<Recruitment> recruitments;

    public Catagory() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Recruitment> getRecruitments() {
        return recruitments;
    }

    public void setRecruitments(List<Recruitment> recruitments) {
        this.recruitments = recruitments;
    }
}
