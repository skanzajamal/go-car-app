package com.dto;

import com.enumeration.EngineType;
import com.enumeration.CarStatus;
import lombok.Data;

@Data
public class CarDto {

    private Integer id;

    private String licensePlate;

    private Integer seatCount;

    private Boolean convertible;

    private Integer rating;

    private EngineType engineType;

    private CarStatus carStatus;

    private String manufacturer;

} //ENDCLASS
