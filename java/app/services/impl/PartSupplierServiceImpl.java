package app.services.impl;

import app.dto.add.AddPartSupplierDto;
import app.dto.add.PartSupplierDto;
import app.dto.views.LocalSupplier;
import app.models.PartSupplier;
import app.repositories.PartSupplierRepository;
import app.services.PartSupplierService;
import app.utils.DtoMappingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartSupplierServiceImpl implements PartSupplierService {
    private PartSupplierRepository partSupplierRepository;

    @Autowired
    public PartSupplierServiceImpl(PartSupplierRepository partSupplierRepository) {
        this.partSupplierRepository = partSupplierRepository;
    }

    @Override
    public void savePartSupplier(AddPartSupplierDto supplier) {
        this.partSupplierRepository.saveAndFlush(DtoMappingUtil.convert(supplier, PartSupplier.class));
    }

    @Override
    public List<PartSupplierDto> findAllSuppliers() {
        return DtoMappingUtil.convert(this.partSupplierRepository.findAll(), PartSupplierDto.class);
    }

    @Override
    public List<LocalSupplier> findAllByImporterIsFlase() {
        return DtoMappingUtil.convert(this.partSupplierRepository.findAllByImporterIsFalse(), LocalSupplier.class);
    }

}
