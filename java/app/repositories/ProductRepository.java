package app.repositories;

import app.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product AS p WHERE p.buyer IS NULL AND p.price BETWEEN 500 AND 1000 " +
            "ORDER BY p.price ASC")
    List<Product> findProductsInPriceRange();


}
