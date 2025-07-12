package com.dto;

import com.entity.CarEntity;
import com.enumeration.DriverStatus;
import lombok.Data;

@Data
public class DriverDto {

    private int driverId;

    private String userName;

    private String password;

    private DriverStatus status;

    private Double latitude;

    private Double longitude;

    // map the selected car to the driver
    private CarEntity car;

} //ENDCLASS
