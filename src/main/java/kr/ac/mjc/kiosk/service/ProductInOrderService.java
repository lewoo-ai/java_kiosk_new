package kr.ac.mjc.kiosk.service;

import kr.ac.mjc.kiosk.domain.OrderMain;
import kr.ac.mjc.kiosk.domain.ProductInOrder;
import kr.ac.mjc.kiosk.domain.User;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface ProductInOrderService {
    void update(String itemId, Integer quantity, User user);

    ProductInOrder findOne(String itemId, User user);
}
