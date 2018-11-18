package com.recruit.paythem.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * This HeadHunter class use for the persist head hunter details.
 *
 */
@Entity
@Table(name="head_hunter")
public class HeadHunter implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String address;

    private String mobile;

    private String name;

    //bi-directional many-to-one association to Payment
    @OneToMany(mappedBy="headHunter")
    private List<Payment> payments;

    //bi-directional many-to-one association to Recruitment
    @OneToMany(mappedBy="headHunter")
    private List<Recruitment> recruitments;

    public HeadHunter() {
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

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<Recruitment> getRecruitments() {
        return recruitments;
    }

    public void setRecruitments(List<Recruitment> recruitments) {
        this.recruitments = recruitments;
    }
}
