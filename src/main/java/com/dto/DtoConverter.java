package com.dto;

import com.entity.CarEntity;
import com.entity.DriverEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class DtoConverter {

    public static CarDto toDto(CarEntity carEntity) {

        CarDto carDto = new CarDto();
        carDto.setId(carEntity.getId());
        carDto.setLicensePlate(carEntity.getLicensePlate());
        carDto.setSeatCount(carEntity.getSeatCount());
        carDto.setConvertible(carEntity.getConvertible());
        carDto.setRating(carEntity.getRating());
        carDto.setEngineType(carEntity.getEngineType());
        carDto.setCarStatus(carEntity.getCarStatus());
        carDto.setManufacturer(carEntity.getManufacturer());
        return carDto;
    }

    public static DriverDto toDto(DriverEntity driverEntity) {

        DriverDto driverDto = new DriverDto();
        driverDto.setDriverId(driverEntity.getDriverId());
        driverDto.setUserName(driverEntity.getUserName());
        driverDto.setPassword(driverEntity.getPassword());
        driverDto.setStatus(driverEntity.getStatus());
        driverDto.setCar(driverEntity.getCar());
        driverDto.setLatitude(driverEntity.getLatitude());
        driverDto.setLongitude(driverEntity.getLongitude());
        driverDto.setStatus(driverEntity.getStatus());
        return driverDto;
    }

    public static List<CarDto> toDtoCarList(List<CarEntity> carEntityList) {

        return carEntityList.stream()
                .map(DtoConverter::toDto).collect(Collectors.toList());
    }

    public static List<DriverDto> toDtoDriverList(List<DriverEntity> driverEntityList) {

        return driverEntityList.stream()
                .map(DtoConverter::toDto).collect(Collectors.toList());
    }


} //ENDCLASS
