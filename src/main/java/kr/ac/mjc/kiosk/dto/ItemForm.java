package kr.ac.mjc.kiosk.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Data
public class ItemForm {

    @Min(value = 1)
    private Integer quantity;
    @NotEmpty
    private String productId;

    public Integer getQuantity() {
        return quantity;
    }

    public String getProductId() {
        return productId;
    }

}
