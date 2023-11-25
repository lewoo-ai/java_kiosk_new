package kr.ac.mjc.kiosk.repository;

import kr.ac.mjc.kiosk.domain.OrderMain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderMain, Integer> {
}
