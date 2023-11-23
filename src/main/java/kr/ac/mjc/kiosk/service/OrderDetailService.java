package kr.ac.mjc.kiosk.service;

import java.awt.print.Pageable;

public interface OrderDetailService {
    Page<OrderMain> findAll(Pageable pageable);

    Page<OrderMain> findByStatus(Integer status, Pageable pageable);

    Page<OrderMain> findByBuyerEmail(String email, Pageable pageable);

    Page<OrderMain> findByBuyerPhone(String phone, Pageable pageable);

    OrderMain findOne(Long orderId);

    OrderMain finish(Long orderId);

    OrderMain cancel(Long orderId);
}
