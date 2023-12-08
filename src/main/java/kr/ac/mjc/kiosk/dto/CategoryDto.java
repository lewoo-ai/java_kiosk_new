package kr.ac.mjc.kiosk.dto;

import kr.ac.mjc.kiosk.domain.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class CategoryDto {

    private Long id;
    private String categoryCode;
    private String categoryName;
    private List<ProductDto> productList;

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.categoryCode = category.getCategoryCode();
        this.categoryName = category.getCategoryName();
        this.productList = category.getProductList().stream()
                .map(ProductDto::new)
                .collect(Collectors.toList());
    }



    public String getCategoryName() {
        return categoryName;
    }

    public Category toEntity() {
        Category category = new Category();
        category.setId(this.id);
        category.setCategoryCode(this.categoryCode);
        category.setCategoryName(this.categoryName);

        if (this.productList != null) {
            category.getProductList().clear();
            category.getProductList().addAll(
                    this.productList.stream()
                            .map(ProductDto::toEntity)
                            .collect(Collectors.toList())
            );
        }

        return category;
    }


}
