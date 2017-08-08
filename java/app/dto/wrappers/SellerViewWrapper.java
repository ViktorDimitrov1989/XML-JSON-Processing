package app.dto.wrappers;

import app.dto.viewModels.SellerView;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "users")
public class SellerViewWrapper {

    @XmlElement(name = "user")
    private List<SellerView> sellers;

    public SellerViewWrapper() {

    }

    public List<SellerView> getSellers() {
        return sellers;
    }

    public void setSellers(List<SellerView> sellers) {
        this.sellers = sellers;
    }
}
