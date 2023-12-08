package kr.ac.mjc.kiosk.service;

import kr.ac.mjc.kiosk.domain.Orders;
import kr.ac.mjc.kiosk.domain.Product;
import kr.ac.mjc.kiosk.repository.ManagerInterface;
import kr.ac.mjc.kiosk.repository.ManagerInterfaceImpl;

import java.sql.SQLException;
import java.util.List;


public class ManagerServiceImpl implements MangerService{
    private ManagerInterface managerInterface = new ManagerInterfaceImpl();
    @Override
    public void productInsert(Product product) throws SQLException {
        int result = managerInterface.productInsert(product);
        if(result == 0) throw new SQLException("상품 등록이 실패하였습니다.");

    }

    @Override
    public void productUpdate(Product product) throws SQLException {
        int result = managerInterface.productUpdate(product);
        if(result == 0) throw new SQLException("상품 수정이 실패하였습니다.");

    }

    @Override
    public void productDelete(String productCode) throws SQLException {
        int result = managerInterface.productDelete(productCode);
        if(result == 0) throw new SQLException(productCode + "와 일치하는 상품이 없습니다.");

    }

    @Override
    public void bundleDelete(String bundleCode) throws SQLException {

    }


}

    @Override
    public List<Orders> ordersSelect() throws SQLException {
        List<Orders> ordersList = managerInterface.ordersSelect();
        if(ordersList == null || ordersList.isEmpty()) throw new SQLException("판매 내역이 없습니다.");
        return ordersList;
    }

}
