package com.example.projecttest.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "subscribers")
public class Subscriber {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "subscriber_code")
    private String subscriberCode;

    @Column(name = "first")
    private String first;

    @Column(name = "last")
    private String last;

    @Column(name = "email")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubscriberCode() {
        return subscriberCode;
    }

    public void setSubscriberCode(String subscriberCode) {
        this.subscriberCode = subscriberCode;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Subscriber(String subscriberCode, String first, String last, String email) {
        this.id = id;
        this.subscriberCode = subscriberCode;
        this.first = first;
        this.last = last;
        this.email = email;
    }
}
