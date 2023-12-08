package kr.ac.mjc.kiosk.service;

import kr.ac.mjc.kiosk.domain.Category;
import kr.ac.mjc.kiosk.domain.Orders;
import kr.ac.mjc.kiosk.repository.CustomerInterface;
import kr.ac.mjc.kiosk.repository.CustomerInterfaceImpl;

import java.sql.SQLException;
import java.util.List;


public class CustomerServiceImpl implements CustomerService {
    CustomerInterface customerInterface = new CustomerInterfaceImpl();

    @Override
    public List<Category> selectProductByCategory() throws SQLException {
        return customerInterface.selectProductByCategory();
    }


    @Override
    public int insertOrders(Orders orders) throws SQLException {
        int result = customerInterface.insertOrders(orders);
        if(result == 0) throw new SQLException("주문이 실패하였습니다.");
        return result;

    }

}
