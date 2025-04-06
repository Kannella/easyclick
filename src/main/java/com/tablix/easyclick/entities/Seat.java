package com.tablix.easyclick.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_seat")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int tableNumber;

    public Seat() {

    }

    public Seat(Long id, int tableNumber) {
        this.id = id;
        this.tableNumber = tableNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", tableNumber=" + tableNumber +
                '}';
    }
}
