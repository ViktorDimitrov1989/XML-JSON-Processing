package app.dto.add;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "part")
public class AddPartDto {
    @Expose
    @XmlAttribute(name = "name")
    private String name;
    @Expose
    @XmlAttribute(name = "price")
    private double price;
    @Expose
    @XmlAttribute(name = "quantity")
    private int quantity;
    @Expose
    private PartSupplierDto supplier;

    public AddPartDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public PartSupplierDto getSupplier() {
        return supplier;
    }

    public void setSupplier(PartSupplierDto supplier) {
        this.supplier = supplier;
    }
}
