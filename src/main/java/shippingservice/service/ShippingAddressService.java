package shippingservice.service;


import shippingservice.dto.AreaDto;
import shippingservice.dto.CityDto;
import shippingservice.dto.RegionDto;
import shippingservice.exception.ApplicationException;
import shippingservice.model.Area;
import shippingservice.model.City;
import shippingservice.model.Region;

import java.util.List;

public interface ShippingAddressService {
    void createAddress(RegionDto regionDto) throws ApplicationException;
    void createAddress(AreaDto areaDto) throws ApplicationException;
    void createAddress(CityDto cityDto) throws ApplicationException;
    List<Region> getAllRegionAddress();
    List<City> getAllCityAddressByRegion(long regionId);
    List<Area> getAllAreaAddressByCity(long cityId);
}
