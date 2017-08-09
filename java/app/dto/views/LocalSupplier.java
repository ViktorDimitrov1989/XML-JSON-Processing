package app.dto.views;

import app.models.Part;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;
import java.util.Set;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "supplier")
public class LocalSupplier {
    @Expose
    @SerializedName("Id")
    @XmlAttribute(name = "id")
    private Long id;
    @Expose
    @SerializedName("Name")
    @XmlAttribute(name = "name")
    private String name;
    @Expose
    @XmlAttribute(name = "parts-count")
    private int partsCount;
    @XmlTransient
    private Set<Part> parts;

    public LocalSupplier() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPartsCount() {
        return this.partsCount;
    }

    public void setPartsCount(int partsCount) {
        this.partsCount = partsCount;
    }

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }
}
