package shippingservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shippingservice.model.Area;

@Repository
public interface AreaAddressRepository extends JpaRepository<Area,Long> {
}
