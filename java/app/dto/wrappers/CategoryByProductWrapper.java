package app.dto.wrappers;

import app.dto.viewModels.CategoryByProductView;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "categories")
public class CategoryByProductWrapper implements Serializable {

    @XmlElement(name = "category")
    private List<CategoryByProductView> categories;

    public CategoryByProductWrapper() {
        this.categories = new ArrayList<>();
    }

    public List<CategoryByProductView> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryByProductView> categories) {
        this.categories = categories;
    }
}
