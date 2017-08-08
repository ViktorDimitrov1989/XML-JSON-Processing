package app.services.impl;

import app.dto.add.AddCarDto;
import app.dto.add.CarDto;
import app.dto.views.CarView;
import app.dto.views.ToyotaView;
import app.models.Car;
import app.repositories.CarRepository;
import app.services.CarService;
import app.utils.DtoMappingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void saveCar(AddCarDto car) {
        this.carRepository.saveAndFlush(DtoMappingUtil.convert(car, Car.class));
    }

    @Override
    public List<CarDto> getCarsToSet() {
        return DtoMappingUtil.convert(this.carRepository.findAll(), CarDto.class);
    }

    @Override
    public List<ToyotaView> getAllToyotas() {
        return DtoMappingUtil.convert(this.carRepository.getAllToyotas(), ToyotaView.class);
    }

    @Override
    public List<CarView> findAllWithParts() {
        return DtoMappingUtil.convert(this.carRepository.findAll(), CarView.class);
    }

}
