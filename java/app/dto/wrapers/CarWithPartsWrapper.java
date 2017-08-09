package app.dto.wrapers;

import app.dto.views.CarView;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "cars")
public class CarWithPartsWrapper {

    @XmlElement(name = "car")
    private List<CarView> cars;

    public CarWithPartsWrapper() {
    }

    public List<CarView> getCars() {
        return cars;
    }

    public void setCars(List<CarView> cars) {
        this.cars = cars;
    }
}
