package kr.ac.mjc.kiosk.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@EntityListeners(AuditingEntityListener.class)

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long id;

    @Column(name="productCode", updatable = false)
    private String productCode;

    @Column(name ="productName", nullable = false)
    private String productName;

    @Column(name = "categoryCode;", nullable = false)
    private String categoryCode;

    @Column(name = "productPrice;", nullable = false)
    private Integer productPrice;


    @Column(name = "productDetails", nullable = false)
    private String productDetails;

    @Column(name = "productOptions", nullable = false)
    private String productOptions;

    @Column(name = "productImage", nullable = false)
    private String productImage;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


    public Product() {
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDetails = productDetails;
        this.productOptions = productOptions;
        this.productImage = productImage;
    }


    public void update(String productCode, String productName, Integer productPrice,
                       String productDetails, String productOptions, String productImage) {

        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDetails = productDetails;
        this.productOptions = productOptions;
        this.productImage = productImage;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public String getProductOptions() {
        return productOptions;
    }

    public void setProductOptions(String productOptions) {
        this.productOptions = productOptions;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }
}
