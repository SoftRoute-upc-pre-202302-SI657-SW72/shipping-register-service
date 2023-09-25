package upc.edu.pe.softroute.shippingregisterservice.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import upc.edu.pe.softroute.shippingregisterservice.domain.models.ShippingCompany;
import upc.edu.pe.softroute.shippingregisterservice.domain.repository.IShippingCompanyRepository;
import upc.edu.pe.softroute.shippingregisterservice.domain.services.IShippingCompanyService;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ShippingCompanyServiceImpl implements IShippingCompanyService {

    private final IShippingCompanyRepository shippingCompanyRepository;

    public ShippingCompanyServiceImpl(IShippingCompanyRepository shippingCompanyRepository) {
        this.shippingCompanyRepository = shippingCompanyRepository;
    }
    @Override
    @Transactional
    public ShippingCompany save(ShippingCompany shippingCompany) throws Exception {
        return shippingCompanyRepository.save(shippingCompany);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        shippingCompanyRepository.deleteById(id);
    }

    @Override
    public List<ShippingCompany> getAll() throws Exception {
        return shippingCompanyRepository.findAll();
    }

    @Override
    public Optional<ShippingCompany> getById(Long id) throws Exception {
        return shippingCompanyRepository.findById(id);
    }

    @Override
    public  Optional<ShippingCompany> findShippingCompanyByShippingCompanyRuc(String ruc) throws Exception {
        return shippingCompanyRepository.findShippingCompanyByShippingCompanyRuc(ruc);
    }
}
