package app.dto.wrappers;

import app.dto.add.CategoryAddDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriesDto {
    @XmlElement(name = "category")
    private List<CategoryAddDto> categories;

    public CategoriesDto() {
    }

    public List<CategoryAddDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryAddDto> categories) {
        this.categories = categories;
    }
}
