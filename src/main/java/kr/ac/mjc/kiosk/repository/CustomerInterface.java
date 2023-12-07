package kr.ac.mjc.kiosk.repository;

import java.sql.SQLException;
import java.util.List;

import kiosk.mvc.model.dto.Category;
import kiosk.mvc.model.dto.Orders;
import kiosk.mvc.model.dto.Product;
public interface CustomerInterface {
    /**
     * 카테고리별로 상품의 정보를 가져오는 메소드
     * select.productByCategory=select * from category join product using(category_code)
     * */
    List<Category> selectProductByCategory() throws SQLException;

    /**
     * 주문 완료시 주문 내역을 저장하는 메소드
     * insert.orders=insert into orders(orders_code, orders_price, orders_date) values(orders_seq.nextval, ?, default)
     * */
    int insertOrders(Orders orders) throws SQLException;
}
