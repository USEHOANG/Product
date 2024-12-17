package sping.api.spingboot.api.Brand.service;

import org.springframework.stereotype.Service;
import sping.api.spingboot.api.Brand.entity.Brand;

import java.util.List;

@Service
public interface BrandService {
    List<Brand> getAllBrand();
}
