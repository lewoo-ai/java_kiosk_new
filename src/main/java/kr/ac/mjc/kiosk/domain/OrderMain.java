package kr.ac.mjc.kiosk.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    @Column(name="ordersCode", updatable = false)
    private String ordersCode;

    @Column(name ="ordersPrice", nullable = false)
    private Integer ordersPrice;

    @Column(name="ordersDate", updatable = false)
    private String ordersDate;

    private List<ProductInOrder>
            productInOrderList = new ArrayList<ProductInOrder>();

    @ManyToOne
    @JoinColumn(name = "productInOrderId", nullable = false)
    private ProductInOrder productInOrder;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductInfo productInfo;

    @Builder
    public ProductInOrder getProductInOrder() {
        return productInOrder;
    }

    public void setProductInOrder(ProductInOrder productInOrder) {
        this.productInOrder = productInOrder;
    }


}
