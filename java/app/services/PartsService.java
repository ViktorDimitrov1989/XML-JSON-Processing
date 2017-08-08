package app.services;


import app.dto.add.AddPartDto;
import app.dto.add.PartDto;

import java.util.List;

public interface PartsService {

    void savePart(AddPartDto part);

    List<PartDto> findAllPartsId();

}
