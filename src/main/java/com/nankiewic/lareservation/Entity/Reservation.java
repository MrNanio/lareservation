package com.nankiewic.lareservation.Entity;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime effectiveDataTime;
    private LocalDateTime expirationDateTime;
    private BigDecimal cost;
    private String description;
    private String status;
    @ManyToOne
    @JoinColumn(name = "RoomFk", nullable = false)
    private Room room;
    @ManyToOne
    @JoinColumn(name = "CustomerFk", nullable = false)
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getEffectiveDataTime() {
        return effectiveDataTime;
    }

    public void setEffectiveDataTime(LocalDateTime effectiveDataTime) {
        this.effectiveDataTime = effectiveDataTime;
    }

    public LocalDateTime getExpirationDateTime() {
        return expirationDateTime;
    }

    public void setExpirationDateTime(LocalDateTime expirationDateTime) {
        this.expirationDateTime = expirationDateTime;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
