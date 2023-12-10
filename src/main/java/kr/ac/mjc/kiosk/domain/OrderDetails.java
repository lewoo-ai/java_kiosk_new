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
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "orderDetailCode", updatable = false)
    private String orderDetailCode; // 주문 상세 코드는 일반적으로 문자열로 사용

    @Column(name = "ordersCode", nullable = false)
    private String ordersCode;

    @Column(name = "productCode", nullable = false)
    private String productCode;

    @Column(name = "ordersDetailsQTY", nullable = false)
    private Integer ordersDetailsQTY;

    @ManyToOne
    @JoinColumn(name = "order_id") //
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}