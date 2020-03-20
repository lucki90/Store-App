package pl.luckit.model;

import lombok.Data;
import pl.luckit.entity.Ingredient;
import pl.luckit.entity.Order;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
@Data
public class ShoppingCartBean {

    private Order order = new Order();
    private Ingredient ingredient;



}
