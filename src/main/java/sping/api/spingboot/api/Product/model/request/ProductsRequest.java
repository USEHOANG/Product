package sping.api.spingboot.api.Product.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductsRequest {

    private String Name;

    private String Color;

    private Integer quantity;

    private Integer sellPrice;

    private  Integer originalPrice;

    private Integer brandId;

    private Integer subcategoryId;

    private Integer status_id;


}
