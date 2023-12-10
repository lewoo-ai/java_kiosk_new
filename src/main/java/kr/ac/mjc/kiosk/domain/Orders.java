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


    @OneToMany(mappedBy = "order")
    private List<OrderDetails> orderDetailsList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(Long orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getOrdersPrice() {
        return ordersPrice;
    }

    public void setOrdersPrice(Integer ordersPrice) {
        this.ordersPrice = ordersPrice;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }

    @Override
    public String toString() {
        return "주문번호 " + orderCode + "의 주문 금액 : " + ordersPrice + "원 주문 날짜 : " + orderDate;
    }



}
