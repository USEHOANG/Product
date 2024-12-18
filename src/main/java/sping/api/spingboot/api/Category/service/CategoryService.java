package sping.api.spingboot.api.Category.service;

import org.springframework.stereotype.Service;
import sping.api.spingboot.api.Category.entity.Category;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> getAll();

    Category Edit(Long id);

    int addCategory(Category category);

    int updateCategory(Long id, Category category);

    void deleteCategory(Long id);

    List<Category> Search(String keyword);
}
