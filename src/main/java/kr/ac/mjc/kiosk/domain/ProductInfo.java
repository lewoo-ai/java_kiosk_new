package kr.ac.mjc.kiosk.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)

public class ProductInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long id;

    @Column(name="productCode", updatable = false)
    private String productCode;

    @Column(name ="productName", nullable = false)
    private String productName;

    @Column(name="categoryCode", updatable = false)
    private String categoryCode;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "productDetails", nullable = false)
    private String productDetails;

    @Column(name = "productOptions", nullable = false)
    private String productOptions;

    @Column(name = "productImage", nullable = false)
    private String productImage;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private ProductCategory category;
}
