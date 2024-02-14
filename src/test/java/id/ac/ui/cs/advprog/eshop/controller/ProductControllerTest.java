package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    @Mock
    private Model model;

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Samsung Phone");
        product.setProductQuantity(250);
    }

    @Test
    void testCreateProductPage() {
        String viewName = productController.createProductPage(model);

        assertEquals("createProduct", viewName);
        verify(model).addAttribute(eq("product"), any(Product.class));
    }

    @Test
    void testCreateProductPost() {
        String redirectURL = productController.createProductPost(product, model);

        assertEquals("redirect:list", redirectURL);
        verify(productService).create(product);
    }

    @Test
    void testProductListPage() {
        String viewName = productController.productListPage(model);

        assertEquals("productList", viewName);
        verify(productService).findAll();
    }

    @Test
    void testEditProductPage() {
        String productId = "eb558e9f-1c39-460e-8860-71af6af63bd6";
        when(productService.findById(productId)).thenReturn(product);

        String viewName = productController.editProductPage(productId, model);

        assertEquals("editProduct", viewName);
        verify(model).addAttribute("product", product);
    }

    @Test
    void testEditProductPost() {
        String redirectURL = productController.editProductPost(product,model);

        assertEquals("redirect:list", redirectURL);
        verify(productService).editProduct(product);
    }

    @Test
    void testDeleteProduct() {
        String productId = "eb558e9f-1c39-460e-8860-71af6af63bd6";

        String redirectURL = productController.deleteProduct(productId, model);

        assertEquals("redirect:../list", redirectURL);
        verify(productService).deleteProduct(productId);
    }
}