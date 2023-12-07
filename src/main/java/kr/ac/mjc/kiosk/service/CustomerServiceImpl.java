package kr.ac.mjc.kiosk.service;

public interface CustomerServiceImpl {


    public class CustomerServiceImpl implements CustomerService {
        CustomerDAO customerDAO = new CustomerDAOImpl();

        @Override
        public List<Category> selectProductByCategory() throws SQLException {
            return customerDAO.selectProductByCategory();
        }

        @Override
        public List<Bundle> selectBundle() throws SQLException {
            return customerDAO.selectBundle();
        }

        @Override
        public int insertOrders(Orders orders) throws SQLException {
            int result = customerDAO.insertOrders(orders);
            if(result == 0) throw new SQLException("주문이 실패하였습니다.");
            return result;

        }
}
