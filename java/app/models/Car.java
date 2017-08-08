package app.models;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Set;

@Entity
@Table(name = "findCarsPriceByCustomer")
public class Car {
    private Long id;
    private String make;
    private String model;
    private Long travelledDistance;
    private Set<Part> parts;
    private Sale sale;

    public Car() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "make")
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Column(name = "model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "travelled_distance")
    public Long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "cars_parts", joinColumns =
            @JoinColumn(name = "car_id", referencedColumnName = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "part_id", referencedColumnName = "part_id"))
    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }

    @OneToOne(cascade = CascadeType.MERGE)
    @PrimaryKeyJoinColumn
    public Sale getSale() {
        return sale;
    }


    public void setSale(Sale sale) {
        this.sale = sale;
    }
}
