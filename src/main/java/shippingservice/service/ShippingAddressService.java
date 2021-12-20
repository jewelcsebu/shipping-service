package shippingservice.service;


import shippingservice.dto.AreaDto;
import shippingservice.dto.RegionDto;

public interface ShippingAddressService {

    void createArea(AreaDto areaDto);

    void createRegion(RegionDto regionDto);
}
