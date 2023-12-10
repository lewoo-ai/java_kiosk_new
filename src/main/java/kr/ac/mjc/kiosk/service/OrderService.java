package kr.ac.mjc.kiosk.service;

import jakarta.transaction.Transactional;
import kr.ac.mjc.kiosk.domain.Orders;
import kr.ac.mjc.kiosk.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
@Transactional

public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;
    @Autowired
    private final ProductService productService;


    public OrderService(OrderRepository orderRepository, ProductService productService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
    }
    public Long createOrder() {
        Orders order = new Orders();
        order.setOrderCode(generateOrderCode());
        order.setOrdersPrice(0);
        order.setOrderDate(LocalDateTime.now());

        Orders savedOrder = orderRepository.save(order);
        return savedOrder.getId();
    }

    private Long generateOrderCode() {
        return LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
    }

    public void addProductToOrder(Long orderId, String productCode) {
        Integer productPrice = productService.getProductPriceByCode(productCode);

        Orders order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("주문을 찾을 수 없습니다."));

        order.setOrdersPrice(order.getOrdersPrice() + productPrice);
    }
}