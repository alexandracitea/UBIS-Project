package com.ubisProject.models;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "ticket")
public class Ticket implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(nullable = false)
private Long ticketId;

@Column(length = 500, nullable = false)
private String nameOfTheEvent;

@Column(length = 500)
private int seatNo;

@Column(length = 500, nullable=false)
private int price;

@Column(length = 500, nullable=false)
private String type; //VIP,standard, etc


public Long getTicketId() {
        return ticketId;
    }

public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

public String getNameOfTheEvent() {
        return nameOfTheEvent;
    }

public void setNameOfTheEvent(String nameOfTheEvent) {
        this.nameOfTheEvent = nameOfTheEvent;
    }

public int getSeatNo() {
        return seatNo;
    }

public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

public int getPrice() {
        return price;
    }

public void setPrice(int price) {this.price = price; }

public String getType() {
        return type;
    }

public void setType(String type) {this.type = type; }
}

