package upc.edu.pe.softroute.shippingregisterservice.domain.repository;

import upc.edu.pe.softroute.shippingregisterservice.domain.models.ShippingCompany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface IShippingCompanyRepository extends JpaRepository<ShippingCompany,Long> {
    Optional<ShippingCompany> findShippingCompanyByShippingCompanyRuc(String ruc);

}
