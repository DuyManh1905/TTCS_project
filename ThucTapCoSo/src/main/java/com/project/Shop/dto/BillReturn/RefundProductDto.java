package com.project.Shop.dto.BillReturn;

import com.project.Shop.dto.Product.ProductDetailDto;
import com.project.Shop.dto.Product.ProductDto;
import lombok.Data;

@Data
public class RefundProductDto {
    private String productName;
    private Long productDetailId;
    private String size;
    private String color;

    //Giá trả lại
    private Double momentPriceRefund;

    //Số lượng khách hàng trả lại
    private Integer quantityRefund;
}
