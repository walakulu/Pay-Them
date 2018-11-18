package com.recruit.paythem.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * This Payment class use for the persist head hunter payment details.
 *
 */
@Entity
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name="payment_date")
    private String paymentDate;

    //bi-directional many-to-one association to HeadHunter
    @ManyToOne
    @JoinColumn(name="head_hunter_id")
    private HeadHunter headHunter;

    //bi-directional many-to-one association to PaymentDetail
    @OneToMany(mappedBy="payment")
    private List<PaymentDetail> paymentDetails;

    public Payment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public HeadHunter getHeadHunter() {
        return headHunter;
    }

    public void setHeadHunter(HeadHunter headHunter) {
        this.headHunter = headHunter;
    }

    public List<PaymentDetail> getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(List<PaymentDetail> paymentDetails) {
        this.paymentDetails = paymentDetails;
    }
}