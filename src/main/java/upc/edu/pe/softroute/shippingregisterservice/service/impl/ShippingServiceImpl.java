package upc.edu.pe.softroute.shippingregisterservice.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import upc.edu.pe.softroute.shippingregisterservice.domain.models.Shipping;
import upc.edu.pe.softroute.shippingregisterservice.domain.repository.IShippingRepository;
import upc.edu.pe.softroute.shippingregisterservice.domain.services.IShippingService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ShippingServiceImpl implements IShippingService {
    private final IShippingRepository shippingRepository;

    public ShippingServiceImpl(IShippingRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }

    @Override
    @Transactional
    public Shipping save(Shipping shipping) throws Exception {
        return shippingRepository.save(shipping);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        shippingRepository.deleteById(id);
    }

    @Override
    public List<Shipping> getAll() throws Exception {
        return shippingRepository.findAll();
    }

    @Override
    public Optional<Shipping> getById(Long id) throws Exception {
        return shippingRepository.findById(id);
    }

    @Override
    public List<Shipping> findShippingByShippingDate(String date) throws Exception {
        return shippingRepository.findShippingByShippingDate(date);
    }
}
