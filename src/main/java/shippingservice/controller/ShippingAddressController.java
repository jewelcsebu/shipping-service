package shippingservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shippingservice.dto.AreaDto;
import shippingservice.dto.CityDto;
import shippingservice.dto.RegionDto;
import shippingservice.exception.ApplicationException;
import shippingservice.model.Area;
import shippingservice.model.City;
import shippingservice.model.Region;
import shippingservice.service.ShippingAddressService;
import shippingservice.util.JsonResponseModel;

import java.util.List;

@RestController
@RequestMapping("api/v1/shipping-address")
public class ShippingAddressController {

    private final ShippingAddressService shippingAddressService;

    @Autowired
    public ShippingAddressController(ShippingAddressService shippingAddressService){
        this.shippingAddressService = shippingAddressService;
    }

    @GetMapping("/msg")
    public String displayMessage(){
        return "Hi";
    }

    @PostMapping("/create/region")
    public ResponseEntity<JsonResponseModel> createRegion(@RequestBody RegionDto regionDto) throws ApplicationException {
        if (regionDto.getRegion().trim() == null || regionDto.getRegion().trim().equals("")){
            throw new ApplicationException("Region can't be null or empty!");
        }
        shippingAddressService.createAddress(regionDto);
        JsonResponseModel response = new JsonResponseModel();
        response.setSuccess(true);
        response.setMessage("Region created success!");
        response.setStatus_code("200");
        return new ResponseEntity<JsonResponseModel>(response,HttpStatus.CREATED);
    }

    @PostMapping("/create/city")
    public ResponseEntity<JsonResponseModel> createCity(@RequestBody CityDto cityDto) throws ApplicationException {
        if (cityDto.getCity().trim() == null || cityDto.getCity().trim().equals("")){
            throw new ApplicationException("City can't be null or empty");
        }
        if (cityDto.getRegionId()<=0){
            throw new ApplicationException("Invalid Region Id");
        }

        shippingAddressService.createAddress(cityDto);
        JsonResponseModel response = new JsonResponseModel();
        response.setSuccess(true);
        response.setMessage("City created success!");
        response.setStatus_code("200");
        return new ResponseEntity<JsonResponseModel>(response,HttpStatus.CREATED);

    }

    @PostMapping("/create/area")
    public ResponseEntity<JsonResponseModel> createArea(@RequestBody AreaDto areaDto) throws ApplicationException {

        if (areaDto.getArea().trim() == null || areaDto.getArea().trim().equals("")){
            throw new ApplicationException("Area can't be null or empty");
        }

        if (areaDto.getCityId() <=0){
            throw new ApplicationException("Invalid City Id");
        }

        shippingAddressService.createAddress(areaDto);

        JsonResponseModel response = new JsonResponseModel();
        response.setSuccess(true);
        response.setMessage("Area created success!");
        response.setStatus_code("200");
        return new ResponseEntity<JsonResponseModel>(response,HttpStatus.CREATED);

    }


    @GetMapping("/get/regions")
    public ResponseEntity<List<Region>> getRegions(){
        return new ResponseEntity<>(shippingAddressService.getAllRegionAddress(),HttpStatus.OK);
    }

    @GetMapping("/get/cities")
    public ResponseEntity<List<City>> getCitiesByRegion(@RequestParam long regionId) throws ApplicationException {
        if (regionId<=0){
            throw new ApplicationException("Invalid Region Id!");
        }
        return new ResponseEntity<>(shippingAddressService.getAllCityAddressByRegion(regionId),HttpStatus.OK);
    }

    @GetMapping("/get/areas")
    public ResponseEntity<List<Area>> getAreasByCity(@RequestParam long cityId) throws ApplicationException {
        if (cityId<=0){
            throw new ApplicationException("Invalid City Id!");
        }

        return new ResponseEntity<>(shippingAddressService.getAllAreaAddressByCity(cityId),HttpStatus.OK);
    }




}
