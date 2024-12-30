package sping.api.spingboot.api.Product.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sping.api.spingboot.api.Brand.entity.Brand;
import sping.api.spingboot.api.Brand.service.BrandService;
import sping.api.spingboot.api.Product.model.request.ProductsRequest;
import sping.api.spingboot.api.Product.model.response.ProductResponse;
import sping.api.spingboot.api.Product.service.ProductService;
import sping.api.spingboot.api.SubCategory.entity.SubCategory;
import sping.api.spingboot.api.SubCategory.service.SubcategoryService;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductThymeleafcontroler {
    @Autowired
    private ProductService productService;

    @Autowired
    private SubcategoryService subcategoryService;

    @Autowired
    private BrandService brandService;

    //Danh sách product
    @GetMapping()
    public String getProducts(@RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "10") int size,
                              Model model) {
        Page<ProductResponse> productPage = productService.getProductPhanTrang(page, size);

        model.addAttribute("products", productPage.getContent()); // Danh sách sản phẩm
        model.addAttribute("currentPage", page); // Trang hiện tại
        model.addAttribute("totalPages", productPage.getTotalPages()); // Tổng số trang
        model.addAttribute("size", productPage.getSize()); // Kích thước trang

        return "products";
    }


    @GetMapping("/show-fromAdd")
    public String showProductFromAdd(Model model) {

        List<SubCategory> subcategories = subcategoryService.getAllSubCategory();
        List<Brand> brands = brandService.getAllBrand();

        model.addAttribute("subcategories", subcategories);
        model.addAttribute("brands", brands);
        model.addAttribute("products", new ProductsRequest());

        return "show_addProduct";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute("product") ProductsRequest productsRequest) {
        productService.addP(productsRequest);
        return "redirect:/products";
    }


    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Long id, Model model) {
        ProductResponse product = productService.Edit(id);
        List<SubCategory> subcategories = subcategoryService.getAllSubCategory();
        List<Brand> brands = brandService.getAllBrand();

        model.addAttribute("product", product);
        model.addAttribute("subcategories", subcategories);
        model.addAttribute("brands", brands);

        return "show_updateProduct";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable("id") Long id, @ModelAttribute ProductsRequest productsRequest) {
        productService.updatePro(id, productsRequest);
        return "redirect:/products";
    }

    @GetMapping("/search")
    public String searchProduct( @RequestParam("keyword") String keyword, Model model) {
        List<ProductResponse> products = productService.Search(keyword);
        model.addAttribute("products", products);
        model.addAttribute("keyword", keyword); // giữ lại giá trị tìm kiềm để hiển thị
        return "products";  // trả về danh sách
    }

}
