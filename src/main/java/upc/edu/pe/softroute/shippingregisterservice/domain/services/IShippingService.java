package upc.edu.pe.softroute.shippingregisterservice.domain.services;

import upc.edu.pe.softroute.shippingregisterservice.domain.models.Shipping;

import java.util.List;
import java.util.Optional;

public interface IShippingService extends CrudService<Shipping>{
    List<Shipping> findShippingByShippingDate(String date) throws Exception;
}
