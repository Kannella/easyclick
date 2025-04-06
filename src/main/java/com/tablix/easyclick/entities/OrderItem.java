package com.tablix.easyclick.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;
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

    @ManyToMany
    @JoinTable(
            name = "order_item_menu_item",
            joinColumns = @JoinColumn(name = "order_item_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_item_id")
    )
    private List<MenuItem> menuItems = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderItem() {

    }

    public OrderItem(Long id, int quantity, String observation, double unitPrice, double totalPrice, List<MenuItem> menuItems, Order order) {
        this.id = id;
        this.quantity = quantity;
        this.observation = observation;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.menuItems = menuItems;
        this.order = order;
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

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof OrderItem orderItem)) return false;
        return quantity == orderItem.quantity && Double.compare(unitPrice, orderItem.unitPrice) == 0 && Double.compare(totalPrice, orderItem.totalPrice) == 0 && Objects.equals(id, orderItem.id) && Objects.equals(observation, orderItem.observation) && Objects.equals(menuItems, orderItem.menuItems) && Objects.equals(order, orderItem.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, observation, unitPrice, totalPrice, menuItems, order);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", observation='" + observation + '\'' +
                ", unitPrice=" + unitPrice +
                ", totalPrice=" + totalPrice +
                ", menuItems=" + menuItems +
                ", order=" + order +
                '}';
    }
}


/*
@ManyToOne
@JoinColumn(name = "order_id")
    Essa anotação indica que vários OrderItem podem estar vinculados a um único Order (ou seja, muitos-para-um). O @JoinColumn(name = "order_id") especifica o nome da coluna (chave estrangeira) na tabela do OrderItem que referencia a tabela/entidade Order.
    Em resumo, a relação funciona assim:
        Em OrderItem (lado “muitos” da relação), você tem @ManyToOne @JoinColumn(name = "order_id"), indicando que cada item pertence a um único Order.
        Em Order (lado “um” da relação), você tem @OneToMany(mappedBy = "order"), indicando que vários itens estão vinculados a esse pedido.
 */