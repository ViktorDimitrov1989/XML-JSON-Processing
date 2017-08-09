package app.dto.views;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "car")
public class ToyotaView {
    @Expose
    @SerializedName("Id")
    @XmlAttribute(name = "id")
    private Long id;
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

    public ToyotaView() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
