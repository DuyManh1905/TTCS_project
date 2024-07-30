package com.project.Shop.controller.admin;

import com.project.Shop.dto.ProductDiscount.ProductDiscountCreateDto;
import com.project.Shop.dto.ProductDiscount.ProductDiscountDto;
import com.project.Shop.entity.Category;
import com.project.Shop.entity.ProductDiscount;
import com.project.Shop.repository.ProductDetailRepository;
import com.project.Shop.repository.ProductDiscountRepository;
import com.project.Shop.repository.ProductRepository;
import com.project.Shop.service.CategoryService;
import com.project.Shop.service.ProductDiscountService;
import com.project.Shop.service.ProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductDiscountController {
    private final ProductService productService;

    private final ProductDiscountService productDiscountService;
    private final CategoryService categoryService;
    private final ProductDetailRepository productDetailRepository;
    private final ProductDiscountRepository productDiscountRepository;

    public ProductDiscountController(ProductService productService, ProductRepository productRepository, ProductDiscountService productDiscountService, CategoryService categoryService, ProductDetailRepository productDetailRepository, ProductDiscountRepository productDiscountRepository) {
        this.productService = productService;
        this.productDiscountService = productDiscountService;
        this.categoryService = categoryService;
        this.productDetailRepository = productDetailRepository;
        this.productDiscountRepository = productDiscountRepository;
    }

    @GetMapping("/admin-only/product-discount")
    public String viewProductDiscountPage(Model model, Pageable pageable) {
        List<ProductDiscount> productDiscountList = productDiscountRepository.findAll();
        model.addAttribute("productDiscounts", productDiscountList);
        return "/admin/product-discount";
    }

    @GetMapping("/admin-only/product-discount-create")
    public String viewProductDiscountCreatePage(Model model) {
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        return "/admin/product-discount-create";
    }

    @ResponseBody
    @PostMapping("/api/private/product-discount/multiple")
    public List<ProductDiscountDto> createProductDiscountMultiple(@Valid @RequestBody ProductDiscountCreateDto productDiscountCreateDto) {
        return productDiscountService.createProductDiscountMultiple(productDiscountCreateDto);
    }

    @ResponseBody
    @PostMapping("/api/private/product-discount/{id}/status/{status}")
    public ProductDiscountDto updateProductDiscount(@Valid @PathVariable Long id, @PathVariable boolean status) {
        return productDiscountService.updateCloseProductDiscount(id, status);
    }
}
