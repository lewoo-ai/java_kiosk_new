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
    @Column(name="id", updatable = false)
    private Long id;

    @Column(name="orderDetailCode", updatable = false)
    private Long orderDetailCode;

    @Column(name ="ordersCode", nullable = false)
    private String ordersCode;

    @Column(name ="productCode", nullable = false)
    private String productCode;


    @Column(name ="ordersDetailsQTY", nullable = false)
    private Integer ordersDetailsQTY;


    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("주문상세번호 ");
        builder.append(orderDetailCode);
        builder.append(" | 상품 코드 : ");
        builder.append(productCode);
        builder.append(" | 주문 수량 : ");
        builder.append(ordersDetailsQTY);
        return builder.toString();
    }

}
