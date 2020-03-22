package pl.luckit.dao;

import lombok.Data;
import pl.luckit.entity.Category;
import pl.luckit.entity.Order;
import pl.luckit.entity.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class GeneralDao {
    private static GeneralDao dao;
    private List<Category> categories = new ArrayList<>();
    private List<Product> products = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    public static final int PAGE_SIZE = 3;

    {
        Category processors = new Category(1, "Procesory");
        Category ram = new Category(2, "RAM");
        categories.addAll(Arrays.asList(processors, ram));

        Product p = new Product(1, "Procesor Quad", new BigDecimal(550), 10, processors, "Opis procesora Quad");
        Product p1 = new Product(2, "Procesor Dual", new BigDecimal(350), 10, processors, "Opis procesora Dual");
        Product p2 = new Product(3, "Procesor Single", new BigDecimal(200), 10, processors, "Opis procesora Single");
        Product p3 = new Product(3, "Pamięc 4 GB", new BigDecimal(100), 10, ram, "Opis pamieci RAM");
        products.addAll(Arrays.asList(p, p1, p2, p3));
    }

    private GeneralDao() {
    }

    public static GeneralDao getInstance() {
        if (dao == null) {
            dao = new GeneralDao();
        }
        return dao;
    }

    private List<Product> getProductsByCategory(Category category) {
        List<Product> chosenProducts = null;
        if (category == null) {
            chosenProducts = this.products;
        } else {
            chosenProducts = new ArrayList<>();
            for (Product product : chosenProducts) {
                if (product.getCategory().equals(category)) {
                    chosenProducts.add(product);
                }
            }
        }
        return chosenProducts;
    }

    public List<Product> getProductsByCategory(Category category, int startElement, int numberOfElements) {
        List<Product> chosenProducts = getProductsByCategory(category);
        if (startElement >= chosenProducts.size()) {
            return new ArrayList<Product>();
        } else {
            chosenProducts = chosenProducts.subList(startElement, (Math.min(chosenProducts.size(), startElement + numberOfElements)));
        }
        return chosenProducts;
    }

    public int getQuantityOfProducts(Category category) {
        return getProductsByCategory(category).size();
    }

    public Product getProductById(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getTopProducts(){

        return this.products.subList(0,2);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

}
