package pl.luckit.model;

import lombok.Data;
import pl.luckit.dao.GeneralDao;
import pl.luckit.entity.Product;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
@Data
public class TopProductBean {

    private Product selectedProduct;
    private List<SelectItem> topProducts;
    private GeneralDao dao = GeneralDao.getInstance();

    public TopProductBean() {
        this.topProducts = new ArrayList<SelectItem>();
        List<Product> products = dao.getTopProducts();
        for (Product product : products) {
            this.topProducts.add(new SelectItem(product, product.getName()));
        }
    }
}
