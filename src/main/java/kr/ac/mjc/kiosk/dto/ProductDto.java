package kr.ac.mjc.kiosk.dto;

import kr.ac.mjc.kiosk.domain.Product;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long id;
    private String productName;
    private String productCode;
    private Integer productPrice;
    private String productDetails;
    private String productOptions;
    private String productImage;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.productCode = product.getProductCode();
        this.productName = product.getProductName();
        this.productPrice = product.getProductPrice();
        this.productDetails = product.getProductDetails();
        this.productOptions = product.getProductOptions();
        this.productImage = product.getProductImage();
    }

    public Product toEntity() {
        Product product = new Product();
        product.setId(this.id);
        product.setProductCode(this.productCode);
        product.setProductName(this.productName);
        product.setProductPrice(this.productPrice);
        product.setProductDetails(this.productDetails);
        product.setProductOptions(this.productOptions);
        product.setProductImage(this.productImage);
        return product;
    }
}