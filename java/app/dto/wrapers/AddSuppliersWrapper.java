package app.dto.wrapers;

import app.dto.add.AddPartSupplierDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "suppliers")
public class AddSuppliersWrapper {

    @XmlElement(name = "supplier")
    private List<AddPartSupplierDto> suppliers;

    public AddSuppliersWrapper() {
    }

    public List<AddPartSupplierDto> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<AddPartSupplierDto> suppliers) {
        this.suppliers = suppliers;
    }
}
