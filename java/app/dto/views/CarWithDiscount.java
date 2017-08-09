package app.dto.views;

import app.models.Part;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "car")
public class CarWithDiscount implements Serializable{
    @Expose
    @SerializedName("Make")
    @XmlAttribute(name = "make")
    private String make;
    @Expose
    @SerializedName("Model")
    @XmlAttribute(name = "model")
    private String model;
    @Expose
    @SerializedName("TravelledDistance")
    @XmlAttribute(name = "travelled-distance")
    private Long travelledDistance;
    @XmlTransient
    private List<Part> parts;

    public CarWithDiscount() {
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
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
}
