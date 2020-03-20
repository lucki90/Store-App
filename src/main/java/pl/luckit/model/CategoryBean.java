package pl.luckit.model;


import lombok.Data;
import pl.luckit.dao.GeneralDao;
import pl.luckit.entity.Category;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ListDataModel;

@ManagedBean(name = "categoryBean")
@RequestScoped
@Data
public class CategoryBean {
    private ListDataModel<Category> categories = new ListDataModel<Category>();

    public CategoryBean() {
        categories.setWrappedData(GeneralDao.getInstance().getCategories());
    }

}
