package app.dto.wrapers;

import app.dto.add.AddCarDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "cars")
public class AddCarsWrapper {

    @XmlElement(name = "car")
    private List<AddCarDto> cars;

    public AddCarsWrapper() {
    }

    public List<AddCarDto> getCars() {
        return cars;
    }

    public void setCars(List<AddCarDto> cars) {
        this.cars = cars;
    }
}
