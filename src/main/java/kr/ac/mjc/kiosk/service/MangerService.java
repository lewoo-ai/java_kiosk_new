package kr.ac.mjc.kiosk.service;

import kr.ac.mjc.kiosk.domain.Orders;
import kr.ac.mjc.kiosk.domain.Product;

import java.sql.SQLException;
import java.util.List;

public interface MangerService {
    /**
     * 관리자 상품 등록
     */
    void productInsert(Product product) throws SQLException;

    /**
     * 관리자 상품 수정
     */
    void productUpdate(Product product) throws SQLException;

    /**
     * 관리자 상품 삭제
     */
    void productDelete(String productCode) throws SQLException;


    /**
     * 관리자 세트 삭제
     */
    void bundleDelete(String bundleCode) throws SQLException;

    /**
     * 판매 내역 조회
     * */
    List<Orders> ordersSelect() throws SQLException;

}
