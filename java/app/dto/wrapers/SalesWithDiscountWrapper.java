package app.dto.wrapers;

import app.dto.views.SaleWithDiscount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "sales")
public class SalesWithDiscountWrapper {

    @XmlElement(name = "sale")
    private List<SaleWithDiscount> sales;

    public SalesWithDiscountWrapper() {
    }

    public List<SaleWithDiscount> getSales() {
        return sales;
    }

    public void setSales(List<SaleWithDiscount> sales) {
        this.sales = sales;
    }
}
