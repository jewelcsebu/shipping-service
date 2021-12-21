package shippingservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shippingservice.model.Area;

import java.util.List;
import java.util.Optional;

@Repository
public interface AreaAddressRepository extends JpaRepository<Area,Long> {
    Optional<Area> findByArea(String area);
    List<Area> findByCityId(long cityId);
}
