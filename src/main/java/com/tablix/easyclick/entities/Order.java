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

    //Um pedido tem muitos "mini pedidos" dentro dele (OrderItem).
    @OneToMany(mappedBy = "order")
    private List<OrderItem> items = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "seat_id") // Cria FK seat_id em Order
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

Quando falamos em relacionamentos bidirecionais no JPA/Hibernate,
sempre existe um lado “dono” (owning side) e um lado “mapeado” (inverse side).
Aqui vai um passo a passo para entender:

O lado que “possui” a FK (foreign key) no banco de dados é o lado dono.
    No seu caso, quem “possui” a coluna order_id é a tabela/entidade OrderItem.
    Por isso, em OrderItem fica @ManyToOne @JoinColumn(name = "order_id") private Order order;.
    Esse é o lado que realmente guarda a informação da associação na base de dados.

O outro lado (no seu exemplo, Order) é o lado inverso.
    Em Order, temos @OneToMany(mappedBy = "order") private List<OrderItem> items;.
    O mappedBy = "order" diz ao JPA que ele não deve criar uma coluna de FK em Order; quem mantém a FK é o lado “dono” (OrderItem).
    A string "order" em mappedBy = "order" deve ser exatamente o nome do atributo em OrderItem que faz a relação com Order.

 */