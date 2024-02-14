package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Iterator;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;
    @BeforeEach
    void setUp(){
    }
    @Test
    void testCreateAndFind(){
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }
    @Test
    void testFindAllEmpty(){
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }
    @Test
    void testFindAllIfMoreThanOneProduct(){
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usepp");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testEditByIdProduct() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("God Of War");
        product.setProductQuantity(100);
        productRepository.create(product);

        Product findProductById = productRepository.findById(product.getProductId());
        assertEquals(findProductById.getProductId(), product.getProductId());
        assertEquals(findProductById.getProductName(), product.getProductName());
        assertEquals(findProductById.getProductQuantity(), product.getProductQuantity());

        Product editProductData = new Product();
        editProductData.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        editProductData.setProductName("God Of War 2");
        editProductData.setProductQuantity(300);
        productRepository.editProduct(editProductData);

        Product editedProduct = productRepository.findById(editProductData.getProductId());
        assertEquals(editProductData.getProductId(), editedProduct.getProductId());
        assertEquals("God Of War 2", editedProduct.getProductName());
        assertEquals(300, editedProduct.getProductQuantity());
    }

    @Test
    void testDeleteProduct() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Resident Evil");
        product.setProductQuantity(200);
        productRepository.create(product);

        Product deletedProduct = productRepository.delete(product.getProductId());
        assertEquals(product, deletedProduct);

        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindByIdProductIfItDoesNotExist() {
        Product nokia = new Product();
        nokia.setProductName("Nokia");
        nokia.setProductQuantity(200);
        productRepository.create(nokia);

        Product xiaomi = new Product();
        xiaomi.setProductName("Xiaomi");
        xiaomi.setProductQuantity(200);
        productRepository.create(xiaomi);

        String randomId = UUID.randomUUID().toString();

        Product findProduct = productRepository.findById(randomId);
        assertNull(findProduct);
    }

    @Test
    void testEditProductNotFound() {
        String randomId = UUID.randomUUID().toString();

        Product iphone = new Product();
        iphone.setProductId(randomId);
        iphone.setProductName("Iphone");
        iphone.setProductQuantity(200);

        Product foundedProduct = productRepository.editProduct(iphone);
        assertNull(foundedProduct);
    }

    @Test
    void testDeleteProductNotFound() {
        Product idLessPhone = new Product();
        idLessPhone.setProductName("Phone without id");
        idLessPhone.setProductQuantity(200);

        String randomId = UUID.randomUUID().toString();

        Product foundedProduct = productRepository.delete(randomId);
        assertNull(foundedProduct);
    }

}