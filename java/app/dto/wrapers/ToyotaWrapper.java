package app.dto.wrapers;

import app.dto.views.ToyotaView;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class ToyotaWrapper {

    @XmlElement(name = "car")
    private List<ToyotaView> cars;

    public ToyotaWrapper() {
    }

    public List<ToyotaView> getCars() {
        return cars;
    }

    public void setCars(List<ToyotaView> cars) {
        this.cars = cars;
    }
}
