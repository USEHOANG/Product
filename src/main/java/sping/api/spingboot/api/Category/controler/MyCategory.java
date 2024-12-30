package sping.api.spingboot.api.Category.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import sping.api.spingboot.api.Category.entity.Category;
import sping.api.spingboot.api.Category.service.CategoryService;
import sping.api.spingboot.utils.UrlPath;

import java.util.List;

@RestController
@RequestMapping(UrlPath.Url_API_CATEGORY)
public class MyCategory {
    @Autowired
    private CategoryService categoryService;

//    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @GetMapping
    public List<Category> getCategories() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Category Edit(@PathVariable("id") Long id){
        return categoryService.Edit(id);
    }

    @PostMapping("/add")
    public int addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }

    @PostMapping("/update/{id}")
    public int updateCategory(@PathVariable("id") Long id, @RequestBody Category category){
        return categoryService.updateCategory(id,category);
    }

    @PostMapping("/delete/{id}")
    public List<Category> deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
        return getCategories();
    }

    @GetMapping("/search/{keyword}")
    public List<Category> searchCategory(@PathVariable("keyword") String keyword){
        return categoryService.Search(keyword);
    }
}
