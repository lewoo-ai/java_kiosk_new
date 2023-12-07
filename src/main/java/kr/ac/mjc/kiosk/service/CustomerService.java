package kr.ac.mjc.kiosk.service;

import kr.ac.mjc.kiosk.domain.Category;
import kr.ac.mjc.kiosk.domain.Orders;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {

    /**
     * 카테고리별로 상품의 정보를 가져오는 메소드
     * */
    List<Category> selectProductByCategory()throws SQLException;


    /**
     * 주문완료시 주문 내역을 저장하는 메소드
     * */
    int insertOrders(Orders orders) throws SQLException;
}
