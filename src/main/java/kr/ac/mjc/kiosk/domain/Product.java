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

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long id;

    @Column(name="productCode", updatable = false)
    private Long productCode;

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
}
