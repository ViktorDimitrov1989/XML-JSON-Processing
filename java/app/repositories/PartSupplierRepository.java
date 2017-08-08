package app.repositories;

import app.models.PartSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartSupplierRepository extends JpaRepository<PartSupplier, Long>{

    List<PartSupplier> findAllByImporterIsFalse();

}

