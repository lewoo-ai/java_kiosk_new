package kr.ac.mjc.kiosk.domain;



import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.HashSet;

@Data
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)

public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CartId", updatable = false)
    private Long cartId;

    @OneToOne
    @JoinColumn(name = "userId" , nullable = false)
    private User users;

    @OneToMany
    @JoinColumn(name = "ProductId", nullable = false)
    private Category products;

    @Override
    public String toString() {
        return "Cart{" + "cartId=" + cartId + ", products=" + products + '}';
    }

    public Cart(User user) {
        this.users = user;
    }

}
