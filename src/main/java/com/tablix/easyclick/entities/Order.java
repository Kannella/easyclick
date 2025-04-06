package com.tablix.easyclick.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant orderHour;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> items = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="seat_id")
    private Seat seat;

    @ManyToMany
    @JoinTable(name = "tb_order_user", // nome da tabela intermediária
            joinColumns = @JoinColumn(name = "order_id"),        // FK pra Order
            inverseJoinColumns = @JoinColumn(name = "user_id"))  // FK pra User
    private List<User> users = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getOrderHour() {
        return orderHour;
    }

    public void setOrderHour(Instant orderHour) {
        this.orderHour = orderHour;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderHour=" + orderHour +
                ", status=" + status +
                ", items=" + items +
                ", seat=" + seat +
                ", users=" + users +
                '}';
    }
}


/*
A anotação @OneToMany indica que cada instância de Order pode ter
vários OrderItem associados a ela. O atributo mappedBy = "order"
diz ao JPA/Hibernate que a coluna (chave estrangeira) que faz o
vínculo está definida na entidade OrderItem, especificamente no
campo chamado order. Dessa forma, é a própria entidade OrderItem que
“possui” a relação (ou seja, a coluna de FK fica na tabela correspondente a OrderItem),
enquanto Order apenas declara que está relacionada a muitos OrderItem.
 */