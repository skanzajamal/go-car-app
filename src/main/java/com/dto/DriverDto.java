package com.dto;

import com.entity.CarEntity;
import com.enumeration.DriverStatus;
import lombok.Data;

@Data
public class DriverDto {

    private int driverId;

    private String userName;

    private String password;

    private String coordinate;

    private DriverStatus status;

    // map the selected car to the driver
    private CarEntity car;

} //ENDCLASS
