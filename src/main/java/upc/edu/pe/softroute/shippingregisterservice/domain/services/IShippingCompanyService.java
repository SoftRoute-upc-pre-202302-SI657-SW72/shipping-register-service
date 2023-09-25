package upc.edu.pe.softroute.shippingregisterservice.domain.services;

import upc.edu.pe.softroute.shippingregisterservice.domain.models.ShippingCompany;

import java.util.Optional;

public interface IShippingCompanyService extends CrudService<ShippingCompany>{

    Optional<ShippingCompany> findShippingCompanyByShippingCompanyRuc(String ruc) throws Exception;
}
