package kr.ac.mjc.kiosk.domain;



import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

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
    private User user;

    @OneToMany
    @JoinColumn(name = "cartId", nullable = false)
    private List<ProductCategory> products;

    @Override
    public String toString() {
        return "Cart{" + "cartId=" + cartId + ", products=" + products + '}';
    }

    public Cart(User user, List<ProductCategory> products) {
        this.user = user;
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ProductCategory> getProducts() {
        return products;
    }

    public void setProducts(List<ProductCategory> products) {
        this.products = products;
    }
}
