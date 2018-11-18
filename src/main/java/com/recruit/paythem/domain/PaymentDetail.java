package com.recruit.paythem.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * This PaymentDetail class use for the persist individual recruit payment details.
 *
 */
@Entity
@Table(name="recruitment_payment")
public class PaymentDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "recruitment_id")
    private int recruitmentId;

    //bi-directional many-to-one association to Payment
    @ManyToOne
    private Payment payment;

    public PaymentDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRecruitmentId() {
        return recruitmentId;
    }

    public void setRecruitmentId(int recruitmentId) {
        this.recruitmentId = recruitmentId;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}