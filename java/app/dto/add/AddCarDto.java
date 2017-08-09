package app.dto.add;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "car")
public class AddCarDto {
    @Expose
    @XmlElement(name = "make")
    private String make;
    @Expose
    @XmlElement(name = "model")
    private String model;
    @Expose
    @XmlElement(name = "travelled-distance")
    private Long travelledDistance;
    @Expose
    private List<PartDto> parts;

    public AddCarDto() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public List<PartDto> getParts() {
        return parts;
    }

    public void setParts(List<PartDto> parts) {
        this.parts = parts;
    }
}
