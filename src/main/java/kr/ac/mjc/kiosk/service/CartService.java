package kr.ac.mjc.kiosk.service;


import java.util.Collection;

public interface CartService {

    Cart getCart(User user);
    void mergeLocalCart(Collection<ProductInOrder> productInOrders, User user);

    void delete(String itemId, User user);

    void checkout(User user);
}
