package kr.ac.mjc.kiosk.repository;

import kr.ac.mjc.kiosk.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
