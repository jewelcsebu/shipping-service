package shippingservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shippingservice.model.City;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityAddressRepository extends JpaRepository<City,Long> {
    Optional<City> findByCity(String city);
    List<City> findByRegionId(long regionId);
}
