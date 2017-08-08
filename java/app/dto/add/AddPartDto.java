package app.dto.add;

import com.google.gson.annotations.Expose;

public class AddPartDto {
    @Expose
    private String name;
    @Expose
    private double price;
    @Expose
    private int quantity;
    @Expose
    private PartSupplierDto supplier;

    public AddPartDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public PartSupplierDto getSupplier() {
        return supplier;
    }

    public void setSupplier(PartSupplierDto supplier) {
        this.supplier = supplier;
    }
}
