package sping.api.spingboot.api.Brand.service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sping.api.spingboot.api.Brand.entity.Brand;
import sping.api.spingboot.api.Brand.repository.BrandRepository;
import sping.api.spingboot.api.Brand.service.BrandService;

import java.util.List;

@Service
public class BrandServiceImple implements BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> getAllBrand(){
        return brandRepository.findAll();
    }
}
