package shippingservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shippingservice.model.Region;

@Repository
public interface RegionAddressRepository extends JpaRepository<Region,Long> {
}
