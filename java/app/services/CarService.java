package app.services;

import app.dto.add.AddCarDto;
import app.dto.add.CarDto;
import app.dto.views.CarView;
import app.dto.views.ToyotaView;

import java.util.List;

public interface CarService {

    void saveCar(AddCarDto car);

    List<CarDto> getCarsToSet();

    List<ToyotaView> getAllToyotas();

    List<CarView> findAllWithParts();


}
