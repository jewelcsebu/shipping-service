package shippingservice.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shippingservice.dto.AreaDto;
import shippingservice.dto.CityDto;
import shippingservice.dto.RegionDto;
import shippingservice.exception.ApplicationException;
import shippingservice.model.Area;
import shippingservice.model.City;
import shippingservice.model.Region;
import shippingservice.repository.AreaAddressRepository;
import shippingservice.repository.CityAddressRepository;
import shippingservice.repository.RegionAddressRepository;
import shippingservice.service.ShippingAddressService;

import java.util.List;
import java.util.Optional;

@Service
public class ShippingAddressServiceImpl implements ShippingAddressService {

    private final AreaAddressRepository areaAddressRepository;
    private final RegionAddressRepository regionAddressRepository;
    private final CityAddressRepository cityAddressRepository;

    @Autowired
    public ShippingAddressServiceImpl(AreaAddressRepository areaAddressRepository,RegionAddressRepository regionAddressRepository,CityAddressRepository cityAddressRepository){
        this.areaAddressRepository = areaAddressRepository;
        this.regionAddressRepository = regionAddressRepository;
        this.cityAddressRepository = cityAddressRepository;
    }



    @Override
    public void createAddress(RegionDto regionDto) throws ApplicationException {

        Optional<Region> doesRegionExist = regionAddressRepository.findByRegion(regionDto.getRegion().trim());

        if (!doesRegionExist.isEmpty()){
            throw new ApplicationException(regionDto.getRegion() + " already exist!");
        }

        Region newRegion = new Region();
        newRegion.setRegion(regionDto.getRegion().trim());
        regionAddressRepository.save(newRegion);
    }

    @Override
    public void createAddress(AreaDto areaDto) throws ApplicationException {

        Optional<Area> doesAreaExist = areaAddressRepository.findByArea(areaDto.getArea().trim());
        Optional<City> doesCityExist = cityAddressRepository.findById(areaDto.getCityId());

        if (!doesAreaExist.isEmpty()){
            throw new ApplicationException(areaDto.getArea()  + " already exist!");
        }

        if ((doesCityExist.isEmpty())){
            throw new ApplicationException("City Id "+ areaDto.getCityId() + " not found!");
        }

        Area newArea = new Area();
        newArea.setArea(areaDto.getArea().trim());
        newArea.setCity(doesCityExist.get());

        areaAddressRepository.save(newArea);

    }

    @Override
    public void createAddress(CityDto cityDto) throws ApplicationException {

        Optional<City> doesCityExist = cityAddressRepository.findByCity(cityDto.getCity().trim());
        Optional<Region> doesRegionExist = regionAddressRepository.findById(cityDto.getRegionId());

        if (!doesCityExist.isEmpty()){
            throw new ApplicationException(cityDto.getCity() + "already exist!");
        }
        if (doesRegionExist.isEmpty()){
            throw new ApplicationException("Region Id "+ cityDto.getRegionId() + " not found!");

        }

        City newCity = new City();
        newCity.setCity(cityDto.getCity());
        newCity.setRegion(doesRegionExist.get());
        cityAddressRepository.save(newCity);

    }

    @Override
    public List<Region> getAllRegionAddress() {
        return regionAddressRepository.findAll();
    }

    @Override
    public List<City> getAllCityAddressByRegion(long regionId) {
        return cityAddressRepository.findByRegionId(regionId);
    }

    @Override
    public List<Area> getAllAreaAddressByCity(long cityId) {
        return areaAddressRepository.findByCityId(cityId);
    }


}
