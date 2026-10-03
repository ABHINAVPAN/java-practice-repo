package com.example.crud.service;

import com.example.crud.dto.ProductRequest;
import com.example.crud.model.Product;
import com.example.crud.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void createSavesProductFromRequest() {
        ProductRequest request = new ProductRequest("Keyboard", "Mechanical keyboard", new BigDecimal("79.99"));
        when(productRepository.save(any(Product.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Product product = productService.create(request);

        assertEquals("Keyboard", product.getName());
        assertEquals("Mechanical keyboard", product.getDescription());
        assertEquals(new BigDecimal("79.99"), product.getPrice());
    }

    @Test
    void findByIdThrowsNotFoundWhenProductDoesNotExist() {
        when(productRepository.findById(42L)).thenReturn(Optional.empty());

        assertThrows(ResponseStatusException.class, () -> productService.findById(42L));
    }

    @Test
    void deleteRemovesExistingProduct() {
        Product product = new Product("Mouse", "Wireless mouse", new BigDecimal("25.00"));
        when(productRepository.findById(7L)).thenReturn(Optional.of(product));

        productService.delete(7L);

        verify(productRepository).delete(product);
    }
}