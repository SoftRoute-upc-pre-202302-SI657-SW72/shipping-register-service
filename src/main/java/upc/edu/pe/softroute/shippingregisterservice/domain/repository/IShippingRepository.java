package upc.edu.pe.softroute.shippingregisterservice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.softroute.shippingregisterservice.domain.models.Shipping;

import java.util.List;
import java.util.Optional;
public interface IShippingRepository extends JpaRepository<Shipping,Long> {

    List<Shipping> findShippingByShippingDate(String date);

}
