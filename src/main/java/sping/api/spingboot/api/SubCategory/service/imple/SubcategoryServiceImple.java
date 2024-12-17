package sping.api.spingboot.api.SubCategory.service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sping.api.spingboot.api.SubCategory.entity.SubCategory;
import sping.api.spingboot.api.SubCategory.repository.SubcategoryRepository;
import sping.api.spingboot.api.SubCategory.service.SubcategoryService;

import java.util.List;

@Service
public class SubcategoryServiceImple implements SubcategoryService {
    @Autowired
    private SubcategoryRepository subcategoryRepository;

    public List<SubCategory> getAllSubCategory(){
        return subcategoryRepository.findAll();
    }
}
