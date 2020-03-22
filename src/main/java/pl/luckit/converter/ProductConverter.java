package pl.luckit.converter;


import pl.luckit.dao.GeneralDao;
import pl.luckit.entity.Product;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class ProductConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        int id = Integer.parseInt(value);
        return GeneralDao.getInstance().getProductById(id);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Product product = (Product) value;
//        return String.valueOf(product.getId());
        return product.getId() + "";
    }
}
