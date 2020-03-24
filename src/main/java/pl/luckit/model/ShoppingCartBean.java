package pl.luckit.model;

import lombok.Data;
import pl.luckit.dao.GeneralDao;
import pl.luckit.entity.Ingredient;
import pl.luckit.entity.Order;
import pl.luckit.entity.Product;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.awt.event.ActionEvent;

@ManagedBean
@SessionScoped
@Data
public class ShoppingCartBean {

    private Order order = new Order();
    private Ingredient ingredient;
    private Product selectedProduct;

    public String finalizeOrder() {
        GeneralDao dao = GeneralDao.getInstance();
        dao.addOrder(order);
        order = new Order();

        return "ok";
    }

    public String deleteIngredient() {
        GeneralDao dao = GeneralDao.getInstance();
        for (Ingredient ingredient : order.getIngredients()) {
            if (ingredient.equals(this.ingredient)) {
                order.getIngredients().remove(ingredient);
                break;
            }
        }

        return "";
    }

    public String addToShoppingCart(int id) {
        GeneralDao dao = GeneralDao.getInstance();

        if (selectedProduct==null){
            selectedProduct=dao.getProductById(id);
        }

        for (Ingredient ingredient : order.getIngredients()) {
            if (ingredient.getProduct().equals(selectedProduct)) {
                ingredient.setQuantity(ingredient.getQuantity() + 1);
                return "shopping-cart.xhtml";
            }
        }
        Ingredient newIngredient = new Ingredient(1, selectedProduct.getPrice(), selectedProduct, order);
        order.getIngredients().add(newIngredient);
        return "shopping-cart.xhtml";
    }

    public void actionListener(ActionEvent actionEvent){
         int productId = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("productId"));

        this.selectedProduct = GeneralDao.getInstance().getProductById(productId);
    }


}
