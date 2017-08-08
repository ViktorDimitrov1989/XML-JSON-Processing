package app.repositories;

import app.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

    @Query("SELECT c FROM Customer AS c ORDER BY c.birthDate ASC, c.youngDriver ASC")
    List<Customer>  findAllByOrderByBirthDateAsc();

    @Query("SELECT c FROM Customer AS c WHERE c.sales.size > 0")
    List<Customer> customersByBoughtCars();

}
