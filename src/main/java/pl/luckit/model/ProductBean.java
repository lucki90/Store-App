package pl.luckit.model;


import lombok.Data;
import pl.luckit.dao.GeneralDao;
import pl.luckit.entity.Category;
import pl.luckit.entity.Product;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;
import java.util.List;

@ManagedBean
@SessionScoped
@Data
public class ProductBean {

    private ListDataModel<Product> products = new ListDataModel<Product>();
    private Category category;
    private int page = 0;

    private GeneralDao dao = GeneralDao.getInstance();

    public boolean isPrevious() {
        return this.page > 0;
    }

    public boolean isNext() {
        double maxPageNumber = Math.ceil((dao.getQuantityOfProducts(this.category) + 0.0) / GeneralDao.PAGE_SIZE) - 1;
        return (page < maxPageNumber);
    }

    public ProductBean() {
        this.refreshModel();
    }

    private void refreshModel() {
        List<Product> products = dao.getProductsByCategory(category, page * GeneralDao.PAGE_SIZE, GeneralDao.PAGE_SIZE);
//        List<Product> products = Arrays.asList(new Product(1,"test", new BigDecimal(122),123, new Category(10,"asdasd"),"asdasd"));
        this.products.setWrappedData(products);
    }

}
