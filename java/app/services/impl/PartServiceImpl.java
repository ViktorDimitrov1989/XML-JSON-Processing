package app.services.impl;

import app.dto.add.AddPartDto;
import app.dto.add.PartDto;
import app.models.Part;
import app.repositories.PartsRepository;
import app.services.PartsService;
import app.utils.DtoMappingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartServiceImpl implements PartsService {
    private PartsRepository partsRepository;

    @Autowired
    public PartServiceImpl(PartsRepository partsRepository) {
        this.partsRepository = partsRepository;
    }

    @Override
    public void savePart(AddPartDto part) {
        this.partsRepository.saveAndFlush(DtoMappingUtil.convert(part, Part.class));
    }

    @Override
    public List<PartDto> findAllPartsId() {
        return DtoMappingUtil.convert(this.partsRepository.findAll(), PartDto.class);
    }
}
