package sping.api.spingboot.api.Category.service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sping.api.spingboot.api.Category.entity.Category;

import sping.api.spingboot.api.Category.repository.CategoryRepository;
import sping.api.spingboot.api.Category.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImple implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    @Override
    public  Category Edit(Long id){
        return categoryRepository.findById(id).get();
    }

    @Override
    public int addCategory(Category category){
        return categoryRepository.save(category).getId();
    }
    @Override
    public int updateCategory(Long id, Category category){
        return categoryRepository.save(category).getId();
    }
    @Override
    public  void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
    @Override
    public List<Category> Search(String keyword){
        return categoryRepository.Search(keyword);
    }
}
