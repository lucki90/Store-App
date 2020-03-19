package pl.luckit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;

@Data
@AllArgsConstructor
public class Ingredients {

    private int quantity;
    private BigDecimal price;
    private Product product;
    private Order order;

    public Ingredients() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredients that = (Ingredients) o;
        return product.equals(that.product) &&
                order.equals(that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, order);
    }
}
