package sping.api.spingboot.api.Product.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sping.api.spingboot.api.Product.entity.Product;
import sping.api.spingboot.api.Product.model.request.ProductsRequest;
import sping.api.spingboot.api.Product.model.response.ProductResponse;
import sping.api.spingboot.api.Product.service.ProductService;
import sping.api.spingboot.utils.UrlPath;

import java.util.List;

@RestController
@RequestMapping(UrlPath.Url_API_PRODUCTS)
public class MyProducts {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping()
    public List<ProductResponse> getProductsAll() {
        return productService.getProductAll();
    }



    @GetMapping("/{id}")
    public ProductResponse Edit(@PathVariable("id") Long id) {
        return productService.Edit(id);
    }

    @PostMapping("/add-product")
    public int addProduct(@RequestBody ProductsRequest productRequest) {
        return productService.addProduct(productRequest);
    }

    @GetMapping("/top1-id")
    public Integer getTop1Id() {
        return productService.getTop1Id();
    }

    @PostMapping("/add-product-brand")
    public void addProductBrand(@RequestBody Long idproduct, @RequestBody Long idbrand) {
        productService.addProductBrand(idproduct, idbrand);
    }

    @PostMapping("/add")
    public String addP(@RequestBody ProductsRequest productsRequest) {
        return productService.addP(productsRequest);
    }

    @PostMapping("/delete/{id}")
    public List<Product> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return productService.getAllProducts();
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable("id") Long id, @RequestBody ProductsRequest productsRequest) {
        return productService.updatePro(id, productsRequest);
    }

    @GetMapping("/search/{keyword}")
    public List<ProductResponse> searchProducts(@PathVariable("keyword") String keyword) {
        return productService.Search(keyword);
    }

}
