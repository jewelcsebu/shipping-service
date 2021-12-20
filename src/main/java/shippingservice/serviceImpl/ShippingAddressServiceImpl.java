package shippingservice.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shippingservice.dto.AreaDto;
import shippingservice.dto.RegionDto;
import shippingservice.model.Area;
import shippingservice.model.Region;
import shippingservice.repository.AreaAddressRepository;
import shippingservice.repository.RegionAddressRepository;
import shippingservice.service.ShippingAddressService;

@Service
public class ShippingAddressServiceImpl implements ShippingAddressService {

    private final AreaAddressRepository areaAddressRepository;
    private final RegionAddressRepository regionAddressRepository;

    @Autowired
    public ShippingAddressServiceImpl(AreaAddressRepository areaAddressRepository,RegionAddressRepository regionAddressRepository){
        this.areaAddressRepository = areaAddressRepository;
        this.regionAddressRepository = regionAddressRepository;
    }


    @Override
    public void createArea(AreaDto areaDto) {

        Area newArea = new Area();
        newArea.setArea(areaDto.getArea());
        areaAddressRepository.save(newArea);

    }

    @Override
    public void createRegion(RegionDto regionDto) {
        Region newRegion = new Region();
        newRegion.setRegion(regionDto.getRegion());
        regionAddressRepository.save(newRegion);
    }
}
