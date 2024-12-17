package sping.api.spingboot.api.Product.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import sping.api.spingboot.api.Brand.entity.Brand;
import sping.api.spingboot.api.Status.entity.Status;
import sping.api.spingboot.api.SubCategory.entity.SubCategory;
import sping.api.spingboot.helper.base.entity.BaseEntity;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "product")
public class Product  extends BaseEntity {


    @ManyToOne
    @JoinColumn(name = "subcate_id", nullable = false)
    private SubCategory subCategory;

    @Column(name = "product_name", length = 100)
    private String productName;

    @Column(name = "color", length = 50)
    private String color;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "sell_price")
    private Integer sellPrice;

    @Column(name = "origin_price")
    private Integer originPrice;

    @Column(name = "description", length = 100)
    private String description;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToMany
    @JoinTable(
            name = "product_brand",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "brand_id")
    )

    private List<Brand> brand;




}
