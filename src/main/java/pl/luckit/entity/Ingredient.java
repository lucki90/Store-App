package pl.luckit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;

@Data
@AllArgsConstructor
public class Ingredient {

    private int quantity;
    private BigDecimal price;
    private Product product;
    private Order order;
    private User user;

    public Ingredient() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return product.equals(that.product) &&
                order.equals(that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, order);
    }

    public BigDecimal getSummary() {
        return this.price.multiply(new BigDecimal(this.quantity));
    }
}
