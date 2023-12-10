package kr.ac.mjc.kiosk.dto;

public class OrderDetailsDto {

    private Long id;
    private Long orderDetailCode;
    private String ordersCode;
    private String productCode;
    private Integer ordersDetailsQTY;

    // 생성자
    public OrderDetailsDto(Long id, Long orderDetailCode, String ordersCode, String productCode, Integer ordersDetailsQTY) {
        this.id = id;
        this.orderDetailCode = orderDetailCode;
        this.ordersCode = ordersCode;
        this.productCode = productCode;
        this.ordersDetailsQTY = ordersDetailsQTY;
    }

    // 게터 메서드들
    public Long getId() {
        return id;
    }

    public Long getOrderDetailCode() {
        return orderDetailCode;
    }

    public String getOrdersCode() {
        return ordersCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public Integer getOrdersDetailsQTY() {
        return ordersDetailsQTY;
    }
}