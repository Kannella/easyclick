package com.tablix.easyclick.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_orderitem")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    private String observation;

    private double unitPrice;

    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "menu_item_id")
    private MenuItem menuItem;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderItem() {

    }

    public OrderItem(Long id, int quantity, String observation, double unitPrice, double totalPrice, MenuItem menuItem) {
        this.id = id;
        this.quantity = quantity;
        this.observation = observation;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.menuItem = menuItem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof OrderItem orderItem)) return false;
        return quantity == orderItem.quantity && Double.compare(unitPrice, orderItem.unitPrice) == 0 && Double.compare(totalPrice, orderItem.totalPrice) == 0 && Objects.equals(id, orderItem.id) && Objects.equals(observation, orderItem.observation) && Objects.equals(menuItem, orderItem.menuItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, observation, unitPrice, totalPrice, menuItem);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", observation='" + observation + '\'' +
                ", unitPrice=" + unitPrice +
                ", totalPrice=" + totalPrice +
                ", menuItem=" + menuItem +
                '}';
    }
}
