package sping.api.spingboot.api.Product.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sping.api.spingboot.api.Product.entity.Product;
import sping.api.spingboot.api.Product.model.request.ProductsRequest;
import sping.api.spingboot.api.Product.model.response.ProductResponse;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = """
                    select p.id as 'id', p.product_name as 'ProductName', b.brand_name as 'BrandName',
                    sc.sub_cate_name as 'Subcategory', p.sell_price as 'Price', s.status_name as 'Status'
                    from product p
                    LEFT join brand b on b.id = b.id
                    LEFT join sub_category sc on sc.id = p.subcate_id
                    LEFT join status s on s.id = p.status_id
            """, nativeQuery = true)
    List<ProductResponse> getAllPro();

    @Query(value = """
                    select p.id as'id', p.product_name as'ProductName',p.color as'Color', p.quantity as'Quantity',  p.sell_price as'Price', p.origin_price as'OriginPrice' ,b.brand_name as'BrandName', sc.sub_cate_name as'Subcategory', s.status_name as'Status'
                    from product p
                    LEFT join brand b on b.id = p.id
                    LEFT join sub_category sc on sc.id = p.id
                    LEFT join status s on s.id = p.id
                    WHERE p.id = :id
            """, nativeQuery = true)
    ProductResponse Edit(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = """
            INSERT INTO product (product_name, color, quantity, sell_price, origin_price, subcate_id) VALUES
            (
             :#{#productRequest.name},
             :#{#productRequest.color},
             :#{#productRequest.quantity},
             :#{#productRequest.sellPrice},
             :#{#productRequest.originalPrice},
             :#{#productRequest.subcategoryId}
            )                                                                                              
            """, nativeQuery = true)
    int addProduct(ProductsRequest productRequest);

    @Query(value = """
            SELECT top 1 id FROM product order by id desc
            """, nativeQuery = true)
    Integer getTop1Id();

    @Transactional
    @Modifying
    @Query(value = """
        INSERT INTO product_brand (product_id, brand_id) VALUES
        (
         :idproduct,
         :idbrand
        )
""", nativeQuery = true)
    void addProductBrand(@Param("idproduct") Long idproduct, @Param("idbrand") Long idbrand);


    @Transactional
    @Modifying
    @Query("DELETE FROM Product p WHERE p.id = :id")
    void deleteById(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = """
            UPDATE product
            SET 
                product_name = COALESCE(:#{#productRequest.name}, product_name),
                color = COALESCE(:#{#productRequest.color}, color),
                quantity = COALESCE(:#{#productRequest.quantity}, quantity),
                sell_price = COALESCE(:#{#productRequest.sellPrice}, sell_price),
                origin_price = COALESCE(:#{#productRequest.originalPrice}, origin_price),
                subcate_id = COALESCE(:#{#productRequest.subcategoryId}, subcate_id),
                status_id = COALESCE(:#{#productRequest.status_id}, status_id)
                where id = :id
            """, nativeQuery = true)
    int updateProduct(@Param("id") Long id, @Param("productRequest") ProductsRequest productsRequest);


    @Query(value = """
    select p.id as 'id', p.product_name as 'ProductName', b.brand_name as 'BrandName',
                    sc.sub_cate_name as 'Subcategory', p.sell_price as 'Price', s.status_name as 'Status'
                    from product p
                    LEFT join brand b on b.id = b.id
                    LEFT join sub_category sc on sc.id = p.subcate_id
                    LEFT join status s on s.id = p.status_id
    WHERE LOWER(p.product_name) LIKE LOWER(CONCAT('%', :keyword, '%'))
""", nativeQuery = true)
    List<ProductResponse> Search( @Param("keyword") String keyword);


    @Query(value = """
                    select p.id as 'id', p.product_name as 'ProductName', b.brand_name as 'BrandName',
                    sc.sub_cate_name as 'Subcategory', p.sell_price as 'Price', s.status_name as 'Status'
                    from product p
                    LEFT join brand b on b.id = b.id
                    LEFT join sub_category sc on sc.id = p.subcate_id
                    LEFT join status s on s.id = p.status_id
            """, nativeQuery = true)
    Page<ProductResponse> findAllProducts(Pageable pageable);
}

