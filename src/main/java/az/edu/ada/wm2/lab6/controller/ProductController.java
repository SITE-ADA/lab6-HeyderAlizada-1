package az.edu.ada.wm2.lab6.controller;

import az.edu.ada.wm2.lab6.model.dto.ProductRequestDto;
import az.edu.ada.wm2.lab6.model.dto.ProductResponseDto;
import az.edu.ada.wm2.lab6.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductResponseDto create(@RequestBody ProductRequestDto dto) {
        return productService.createProduct(dto);
    }

    @GetMapping("/{id}")
    public ProductResponseDto getById(@PathVariable UUID id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public List<ProductResponseDto> getAll() {
        return productService.getAllProducts();
    }

    @PutMapping("/{id}")
    public ProductResponseDto update(@PathVariable UUID id,
                                     @RequestBody ProductRequestDto dto) {
        return productService.updateProduct(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/expiring")
    public List<ProductResponseDto> getExpiringBefore(@RequestParam LocalDate date) {
        return productService.getProductsExpiringBefore(date);
    }

    @GetMapping("/price-range")
    public List<ProductResponseDto> getByPriceRange(@RequestParam BigDecimal min,
                                                    @RequestParam BigDecimal max) {
        return productService.getProductsByPriceRange(min, max);
    }
}