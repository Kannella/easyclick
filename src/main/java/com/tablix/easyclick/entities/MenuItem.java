package com.tablix.easyclick.entities;

import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_menuitem")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private double price;
    private String category;
    private String imgUrl;

    //Muitos itens do cardapio se faz presente em muitos pedidos (ou seja, uma lista de pedidos). Dessa forma
    //voce consegue acessar todos os pedidos que tal item esta presente
    @ManyToMany(mappedBy = "menuItems")
    private List<OrderItem> orderItems = new ArrayList<>();

    public MenuItem() {

    }

    public MenuItem(Long id, String name, String description, double price, String category, String imgUrl, List<OrderItem> orderItems) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.imgUrl = imgUrl;
        this.orderItems = orderItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", orderItems=" + orderItems +
                '}';
    }
}
