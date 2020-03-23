package pl.luckit.model;

import lombok.Data;
import pl.luckit.dao.GeneralDao;
import pl.luckit.entity.Product;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
@Data
public class ProductDetailBean {

    private GeneralDao dao = GeneralDao.getInstance();
    private Product chosenProduct;

    @ManagedProperty("#{param.id}")
    private int productId;

    @ManagedProperty("#{topProductBean}")
    private TopProductBean topProductBean;

    public void setProductId(int productId) {
        this.productId = productId;
        if (productId > 0) {
            this.chosenProduct = dao.getProductById(productId);
        }
    }

    public void setTopProductBean(TopProductBean topProductBean) {
        this.topProductBean = topProductBean;
        Product product = topProductBean.getSelectedProduct();
        if (product != null) {
            this.chosenProduct = product;
        }
    }
}
