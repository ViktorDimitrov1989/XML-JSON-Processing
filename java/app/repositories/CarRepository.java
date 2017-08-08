package app.repositories;

import app.models.Car;
import app.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{

    @Query(value = "SELECT c FROM Car AS c WHERE c.make = 'Toyota' ORDER BY c.model ASC, c.travelledDistance DESC ")
    List<Car> getAllToyotas();


}
