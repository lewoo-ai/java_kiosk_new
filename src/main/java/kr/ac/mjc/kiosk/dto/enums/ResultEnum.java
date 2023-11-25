package kr.ac.mjc.kiosk.dto.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    PARAM_ERROR(1, "파라미터 오류!"),
    PRODUCT_NOT_EXIST(10, "상품이 존재하지 않습니다!"),
    PRODUCT_NOT_ENOUGH(11, "재고가 부족합니다!"),
    PRODUCT_STATUS_ERROR(12, "상태가 올바르지 않습니다!"),
    PRODUCT_OFF_SALE(13,"상품이 품절되었습니다!"),
    PRODUCT_NOT_IN_CART(14,"장바구니에 해당 상품이 없습니다!"),
    CART_CHECKOUT_SUCCESS(20, "결제가 성공적으로 완료되었습니다!"),

    CATEGORY_NOT_FOUND(30, "카테고리가 존재하지 않습니다!"),

    ORDER_NOT_FOUND(60, "주문이 존재하지 않습니다!"),
    ORDER_STATUS_ERROR(61, "주문 상태가 올바르지 않습니다!"),

    VALID_ERROR(50, "잘못된 정보입니다!"),
    USER_NOT_FOUNT(40,"사용자를 찾을 수 없습니다!");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
