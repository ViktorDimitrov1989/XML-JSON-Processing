package app.dto.views;

import app.models.Part;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Set;

public class LocalSupplier {
    @Expose
    @SerializedName("Id")
    private Long id;
    @Expose
    @SerializedName("Name")
    private String name;
    @Expose
    private int partsCount;
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
