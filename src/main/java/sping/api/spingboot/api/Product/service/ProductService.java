package sping.api.spingboot.api.Product.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import sping.api.spingboot.api.Product.entity.Product;
import sping.api.spingboot.api.Product.model.request.ProductsRequest;
import sping.api.spingboot.api.Product.model.response.ProductResponse;

import java.util.List;
@Service
public interface ProductService {
    List<Product> getAllProducts();

    List<ProductResponse> getProductAll();

    ProductResponse Edit(Long id);

    int addProduct(ProductsRequest productRequest);

    Integer getTop1Id();

    void addProductBrand(Long idproduct, Long idbrand);

    String addP(ProductsRequest productsRequest);

    void deleteProduct(Long id);

    String updatePro(Long id, ProductsRequest productsRequest);

    List<ProductResponse> Search(String keyword);

    Page<ProductResponse> getProductPhanTrang(int page, int size);
}
