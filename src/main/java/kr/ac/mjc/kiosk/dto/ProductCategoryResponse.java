package kr.ac.mjc.kiosk.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class ProductCategoryResponse {

    private String categoryName;
    private Long categoryId;
    private List<ProductDto> products;

    public ProductCategoryResponse(String categoryName, Long categoryId, List<ProductDto> products) {

    }

    public static ProductCategoryResponse create(String categoryName, Long categoryId, List<ProductDto> products) {
        return new ProductCategoryResponse(categoryName, categoryId, products);
    }

    // 기본 생성자 추가
    public ProductCategoryResponse() {
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
}
