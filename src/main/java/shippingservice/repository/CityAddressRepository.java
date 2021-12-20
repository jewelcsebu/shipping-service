package shippingservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shippingservice.model.City;

@Repository
public interface CityAddressRepository extends JpaRepository<City,Long> {
}
