package alararestaurant.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "order_items")
public class OrderItem extends BaseEntity{

    private Order order;
    private Item item;
    private int quantity;

    public OrderItem() {
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id", referencedColumnName = "id", nullable = false)
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Column(nullable = false, columnDefinition = "INT UNSIGNED")
    @Min(1)
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
