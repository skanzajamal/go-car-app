package com.controller;

import com.dto.CarDto;
import com.dto.DriverDto;
import com.dto.DtoConverter;
import com.entity.DriverEntity;
import com.repository.DriverRepository;
import com.service.DataModelService;
import com.specification.SearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DataModelController {

    @Autowired
    private DataModelService dataModelService;

    @Autowired
    private DriverRepository driverRepository;

    // driver

    @RequestMapping(value = "/driver/criteria/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DriverDto> driverList
            (@RequestParam(value = "status", required = false) String status,
             @RequestParam(value = "coordinate", required = false) String coordinate) {
        SearchRequest request = new SearchRequest(status, coordinate);
        return DtoConverter.toDtoDriverList(dataModelService.driverList(request));
    }

    @RequestMapping(value = "/driver/get/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DriverDto> driverLists(){
        return DtoConverter.toDtoDriverList(dataModelService.driverLists());
    }

    // car
    @RequestMapping(value = "/car/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CarDto> carList(){
        return DtoConverter.toDtoCarList(dataModelService.carList());
    }

    @RequestMapping(value = "driver/{driverId}/car/{carId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void selectCar(@PathVariable int driverId, @PathVariable int carId) throws Exception {
        dataModelService.selectCar(carId, driverId);
    }

    @RequestMapping(value = "/driver/driverId}/car/{carId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deselectCar(@RequestParam int driverId, @RequestParam int carId) throws Exception {
        dataModelService.deselectCar(driverId, carId);
    }

    // crud operations

    @RequestMapping(value = "/driver/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public DriverDto addDriver(@RequestBody DriverEntity driver) {
        return DtoConverter.toDto(dataModelService.addDriver(driver));
    }

    @RequestMapping(value = "/driver/{driverId}/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public DriverDto getDriver(@PathVariable int driverId){
        return DtoConverter.toDto(dataModelService.getDriver(driverId));
    }


} //ENDCLASS
