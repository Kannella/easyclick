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

    @OneToOne(mappedBy = "seat") // A mesa tem um pedido ativo (opcionalmente)
    private Order currentOrder;

    public Seat() {

    }

    public Seat(Long id, int tableNumber, Order currentOrder) {
        this.id = id;
        this.tableNumber = tableNumber;
        this.currentOrder = currentOrder;
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

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", tableNumber=" + tableNumber +
                '}';
    }
}
