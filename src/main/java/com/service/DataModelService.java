package com.service;

import com.enumeration.CarStatus;
import com.enumeration.DriverStatus;
import com.specification.SearchRequest;
import com.specification.SpecificationCriteria;
import com.entity.CarEntity;
import com.entity.DriverEntity;
import com.repository.CarRepository;
import com.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataModelService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private SpecificationCriteria specificationCriteria;


    public List<CarEntity> carList() {

        var records = carRepository.findAll();

        // Sort cars by rating (highest first)
        List<CarEntity> result = records.stream()
                .sorted((car1, car2) -> Integer.compare(car2.getRating(), car1.getRating()))
                .collect(Collectors.toList());
        return result;
    }

    public List<DriverEntity> driverLists() {

        var lists = driverRepository.findAll();

        //available drivers on priority
        var comparator = Comparator.comparing(DriverEntity::getStatus).thenComparing(DriverEntity::getDriverId);
        lists.sort(comparator);
        return lists;
    }

    public List<DriverEntity> driverList(SearchRequest request) {
        return specificationCriteria.findAllBySimpleQuery(request);
    }

    //enable drivers to select a car
    public void selectCar(int carId, int driverId) throws Exception {

        DriverEntity driver = driverRepository.getOne(driverId);
        CarEntity car = carRepository.getOne(carId);

        if (DriverStatus.OFFLINE == driver.getStatus())
        {
            throw new Exception("Driver must be ONLINE to select a car");
        }

        if (driver.getCar() != null)
        {
            throw new Exception("Driver has already selected a Car");
        }

        if (car.getCarStatus() == CarStatus.IN_USE)
        {
            throw new Exception(String.format("Car %s is already in use", carId));
        }

        car.setCarStatus(CarStatus.IN_USE);
        driver.setCar(car);
        driverRepository.save(driver);
        carRepository.save(car);
    }

    //enable drivers to deselect a car
    public void deselectCar(int driverId, int carId) throws Exception {

        DriverEntity driver = driverRepository.getOne(driverId);
        CarEntity car = carRepository.getOne(carId);

        if(driver.getStatus() == DriverStatus.OFFLINE){
            throw new Exception("Driver must be ONLINE to select a car");
        }

        if(driver.getCar() == null){
            throw new Exception("Driver has no car");
        }

        if (car.getCarStatus() == CarStatus.FREE) {
            throw new Exception(String.format("Car %s must be booked before deselecting", carId));
        }

        driver.setCar(null);
        car.setCarStatus(CarStatus.FREE);
        driverRepository.save(driver);
        carRepository.save(car);
    }

    // CRUD operations

    public DriverEntity addDriver(DriverEntity driver){
        return driverRepository.save(driver);
    }

    public DriverEntity getDriver(int driverId) { return driverRepository.getOne(driverId); }

    public void deleteDriver(DriverEntity driver){
        driverRepository.delete(driver);
    }


} //ENDCLASS
