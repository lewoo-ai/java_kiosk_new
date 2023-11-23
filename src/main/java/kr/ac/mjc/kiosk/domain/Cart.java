package kr.ac.mjc.kiosk.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.mapping.Set;
import org.springframework.data.annotation.Id;

import java.util.HashSet;

@Data
@Entity
@NoArgsConstructor
public class Cart {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cartId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JsonIgnore
    private User user;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval = true,
            mappedBy = "cart")
    private Set<ProductInOrder> products = new HashSet<>();

    @Override
    public String toString() {
        return "Cart{" + "cartId=" + cartId + ", products=" + products + '}';
    }

    public Cart(User user) {
        this.user = user;
    }

}
