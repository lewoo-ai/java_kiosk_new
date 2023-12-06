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
    private Long productCode;

    @Column(name ="product_name", nullable = false)
    private String product_name;

    @Column(name = "price", nullable = false)
    private String price;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "option", nullable = false)
    private String option;

    @Column(name = "img", nullable = false)
    private String img;

    @ManyToOne
    @JoinColumn(name = "categoryId", nullable = false)
    private ProductCategory category;
}
