package com.recruit.paythem.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * This Recruitment class use for the persist details of the recruitment(include individual & group recruitment) .
 *
 */
@Entity
public class Recruitment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String comment;

    private String group;

    @Column(name="payment_status")
    private String paymentStatus;

    @Column(name="recruitment_date")
    private String recruitmentDate;

    //bi-directional many-to-one association to Employee
    @OneToMany(mappedBy="recruitment")
    private List<Employee> employees;

    //bi-directional many-to-one association to Catagory
    @ManyToOne
    private Catagory catagory;

    //bi-directional many-to-one association to HeadHunter
    @ManyToOne
    @JoinColumn(name="head_hunter_id")
    private HeadHunter headHunter;

    public Recruitment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getRecruitmentDate() {
        return recruitmentDate;
    }

    public void setRecruitmentDate(String recruitmentDate) {
        this.recruitmentDate = recruitmentDate;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Catagory getCatagory() {
        return catagory;
    }

    public void setCatagory(Catagory catagory) {
        this.catagory = catagory;
    }

    public HeadHunter getHeadHunter() {
        return headHunter;
    }

    public void setHeadHunter(HeadHunter headHunter) {
        this.headHunter = headHunter;
    }
}