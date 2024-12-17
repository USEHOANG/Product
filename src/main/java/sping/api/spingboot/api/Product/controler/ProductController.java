package sping.api.spingboot.api.Product.controler;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sping.api.spingboot.api.Product.entity.Product;
import sping.api.spingboot.api.Product.model.response.ProductResponse;
import sping.api.spingboot.api.Product.service.ProductService;

import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;



    @Operation(summary = "Lấy Danh Sách SP ", description = "API này trả về  DS SP có trong hệ thống ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Thanh Cong"),
            @ApiResponse(responseCode = "404", description = "Khong Tim Thay Du Lieu")
    })
    @GetMapping
    public List<ProductResponse> getProducts() {
        return productService.getProductAll();
    }
}
