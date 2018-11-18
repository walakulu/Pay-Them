package com.recruit.paythem.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * This Employee class use for the persist employee.
 *
 */
@Entity
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String address;

    @Column(name="blood_group")
    private String bloodGroup;

    private String mobile;

    private String name;

    //bi-directional many-to-one association to Catagory
    @ManyToOne
    private Catagory catagory;

    //bi-directional many-to-one association to Recruitment
    @ManyToOne
    private Recruitment recruitment;

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Catagory getCatagory() {
        return catagory;
    }

    public void setCatagory(Catagory catagory) {
        this.catagory = catagory;
    }

    public Recruitment getRecruitment() {
        return recruitment;
    }

    public void setRecruitment(Recruitment recruitment) {
        this.recruitment = recruitment;
    }
}