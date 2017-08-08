package app.services;

import app.dto.add.AddPartSupplierDto;
import app.dto.add.PartSupplierDto;
import app.dto.views.LocalSupplier;
import app.models.PartSupplier;

import java.util.List;

public interface PartSupplierService {

    void savePartSupplier(AddPartSupplierDto supplier);

    List<PartSupplierDto> findAllSuppliers();

    List<LocalSupplier> findAllByImporterIsFlase();
}
