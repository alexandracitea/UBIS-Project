package com.ubisProject.models;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    public Long customerId;

    @Column(length = 500, nullable = false)
    private String name;

    @Column(length = 500, nullable=false)
    private String phone;

    @Column(length = 500, nullable=false)
    private String email;

    @Column(length = 500, nullable=false)
    private String eventName;

    @Column(length = 500, nullable=false)
    private int ticketId;


    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { this.email = email; }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {this.eventName = eventName; }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId (int ticketId) {this.ticketId = ticketId; }
}

