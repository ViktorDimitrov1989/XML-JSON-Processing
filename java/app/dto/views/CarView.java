package app.dto.views;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;
import java.util.Set;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "car")
public class CarView {
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
    @Expose
    @XmlElement(name = "parts")
    private Set<PartView> parts;

    public CarView() {
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

    public Set<PartView> getParts() {
        return parts;
    }

    public void setParts(Set<PartView> parts) {
        this.parts = parts;
    }
}
