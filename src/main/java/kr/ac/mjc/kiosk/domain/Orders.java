package kr.ac.mjc.kiosk.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Orders {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long id;
    @Column(name="orderCode", updatable = false)
    private Long orderCode;

    @Column(name ="ordersPrice", nullable = false)
    private Integer ordersPrice;

    @CreatedDate
    @Column(name="orderDate")
    private LocalDateTime orderDate;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetails> orderDetailsList = new ArrayList<>();



    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("주문번호 ");
        builder.append(orderCode);
        builder.append("의 주문 금액 : ");
        builder.append(ordersPrice);
        builder.append("원 주문 날짜 :");
        builder.append(orderDate);
        return builder.toString();
    }
}
