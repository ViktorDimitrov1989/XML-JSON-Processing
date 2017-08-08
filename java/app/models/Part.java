package app.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "parts")
public class Part {
    private Long id;
    private String name;
    private double price;
    private int quantity;
    private Set<Car> cars;
    private PartSupplier supplier;

    public Part() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "part_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "parts")
    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    public PartSupplier getSupplier() {
        return supplier;
    }

    public void setSupplier(PartSupplier supplier) {
        this.supplier = supplier;
    }
}
