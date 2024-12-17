package sping.api.spingboot.api.Product.service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sping.api.spingboot.api.Product.entity.Product;
import sping.api.spingboot.api.Product.model.request.ProductsRequest;
import sping.api.spingboot.api.Product.model.response.ProductResponse;
import sping.api.spingboot.api.Product.repository.ProductRepository;
import sping.api.spingboot.api.Product.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImple implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductResponse> getProductAll() {
        return productRepository.getAllPro();
    }

    @Override
    public ProductResponse Edit(Long id) {
        return productRepository.Edit(id);
    }

    @Override
    public int addProduct(ProductsRequest productRequest) {
        return productRepository.addProduct(productRequest);
    }

    @Override
    public Integer getTop1Id() {
        return productRepository.getTop1Id();
    }

    @Override
    public void addProductBrand(Long idproduct, Long idbrand) {
        productRepository.addProductBrand(idproduct, idbrand);
    }

    @Override
    public String addP(ProductsRequest productsRequest) {
        try {
            System.out.println("addP called with product: " + productsRequest.getName());

            // Thêm sản phẩm
            int result = addProduct(productsRequest);
            if (result == 0) {
                throw new RuntimeException("Add Failed: Product could not be inserted");
            }

            // Lấy ID sản phẩm mới thêm
            Integer idProduct = getTop1Id();
            if (idProduct == null) {
                throw new RuntimeException("Add Failed: Could not retrieve top product ID");
            }

            // Kiểm tra và thêm liên kết sản phẩm - brand
            if (productsRequest.getBrandId() != null) {
                addProductBrand(idProduct.longValue(), productsRequest.getBrandId().longValue());
            }

            return "Add Success";
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Add Failed: " + e.getMessage());
        }
    }


    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public String updatePro(Long id, ProductsRequest productsRequest) {
        try {
            // kiểm tra xem sản phẩm tồn tại không
            if (!productRepository.existsById(Math.toIntExact(id))) {
                throw new RuntimeException("product id" + id + " not found");
            }

            //Nếu sản phầm không tồn tại thì không thực hiện update
            //nếu sản phẩm tồn tại sẽ thực hiện update sản phẩm
            int result = productRepository.updateProduct(id, productsRequest);
            if (result == 0) {
                throw new RuntimeException("Update Failed");
            }
            //result == 0 update thất bại - result == 1 update thành công

            //cập nhật liên kết với brand
            if (productsRequest.getBrandId() != null) {
                productRepository.addProductBrand(id, productsRequest.getBrandId().longValue());
            }
            return "Update Success";


        } catch (Exception e) {
            throw new RuntimeException("Update Failed: " + e.getMessage());
        }
    }

    @Override
    public  List<ProductResponse> Search(String keyword){
        return productRepository.Search(keyword);
    }

    @Override
    public Page<ProductResponse> getProductPhanTrang(int pageNo, int Pagesize){
        PageRequest pageable = PageRequest.of(pageNo - 1, Pagesize);
        return productRepository.findAllProducts(pageable);
    }


}
