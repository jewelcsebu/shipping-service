package shippingservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shippingservice.dto.RegionDto;
import shippingservice.exception.ApplicationException;
import shippingservice.service.ShippingAddressService;
import shippingservice.util.JsonResponseModel;

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
    public ResponseEntity<JsonResponseModel> createArea(@RequestBody RegionDto regionDto) throws ApplicationException {

        if (regionDto.getRegion().equals(null) || regionDto.getRegion() == ""){
            throw new ApplicationException("Region can't be null or empty!");
        }

        shippingAddressService.createRegion(regionDto);

        JsonResponseModel response = new JsonResponseModel();
        response.setSuccess(true);
        response.setMessage("Region created success!");
        response.setStatus_code("200");

        return new ResponseEntity<JsonResponseModel>(response,HttpStatus.CREATED);


    }

}
