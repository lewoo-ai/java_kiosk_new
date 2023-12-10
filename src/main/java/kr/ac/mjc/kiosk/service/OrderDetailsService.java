package kr.ac.mjc.kiosk.service;

import kr.ac.mjc.kiosk.domain.OrderDetails;
import kr.ac.mjc.kiosk.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderDetailsService {


    @Autowired
    private final OrderDetailsRepository orderDetailsRepository;

    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }


    public List<OrderDetails> getOrderDetailsByOrderId(Long orderId) {
        return orderDetailsRepository.findByOrder_Id(orderId);
    }
}