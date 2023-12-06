package kr.ac.mjc.kiosk.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class OrderMain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long id;

    @Column(name="orderDetailCode", updatable = false)
    private Long orderDetailCode;

    @Column(name ="quantity", nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "productInOrderId", nullable = false)
    private ProductInOrder productInOrder;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductInfo productInfo;



    public Collection<ProductInOrder> getProducts() {
        return null;
    }

    public ProductInOrder getProductInOrder() {
        return productInOrder;
    }

    public void setProductInOrder(ProductInOrder productInOrder) {
        this.productInOrder = productInOrder;
    }
}
