package shippingservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shippingservice.model.Region;

import java.util.Optional;

@Repository
public interface RegionAddressRepository extends JpaRepository<Region,Long> {
    Optional<Region> findByRegion(String region);
}
