package kr.ac.mjc.kiosk.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {

    private Long id;
    private Long orderCode;
    private Integer ordersPrice;
    private LocalDateTime orderDate;


    @Override
    public String toString() {
        return "주문번호 " + orderCode + "의 주문 금액 : " + ordersPrice + "원 주문 날짜 : " + orderDate;
    }
}