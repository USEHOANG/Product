package sping.api.spingboot.api.SubCategory.service;

import org.springframework.stereotype.Service;
import sping.api.spingboot.api.SubCategory.entity.SubCategory;

import java.util.List;

@Service
public interface SubcategoryService {
    List<SubCategory> getAllSubCategory();
}
