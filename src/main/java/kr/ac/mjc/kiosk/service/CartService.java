package kr.ac.mjc.kiosk.service;


import kr.ac.mjc.kiosk.domain.Cart;
import kr.ac.mjc.kiosk.domain.ProductInOrder;
import kr.ac.mjc.kiosk.domain.ProductInfo;
import kr.ac.mjc.kiosk.domain.User;

import java.util.Collection;
import java.util.List;

public interface CartService {
    static List<ProductInfo> findAll() {
    }

    Cart getCart(User user);
    void mergeLocalCart(Collection<ProductInOrder> productInOrders, User user);

    void delete(String itemId, User user);

    void checkout(User user);
}
