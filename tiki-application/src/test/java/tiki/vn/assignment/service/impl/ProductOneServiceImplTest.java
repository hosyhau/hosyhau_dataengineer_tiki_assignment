package tiki.vn.assignment.service.impl;

import org.junit.BeforeClass;
import org.junit.Test;
import tiki.vn.assignment.dto.ProductDto;
import tiki.vn.assignment.entity.Product;
import tiki.vn.assignment.service.ProductService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static tiki.vn.assignment.config.Constants.CONVERT_OBJECT_ERROR;

public class ProductOneServiceImplTest {

    private static ProductService<Product> productService = null;

    private static Product expectedValue = null;

    private static ProductDto productDto = null;

    private static String productName = "Iphone X";

    @BeforeClass
    public static void setUp(){

        productService = new ProductOneServiceImpl();
        productDto = new ProductDto();
        expectedValue = new Product();
        mockData();
    }


    @Test
    public void testCreateOneProductSuccessfully(){

        Product actualValue = productService.createProduct(productDto);

        assertNotNull(actualValue);
    }

    @Test
    public void testMatchingProductName(){

        Product actualValue = productService.createProduct(productDto);

        assertEquals(actualValue.getName(), expectedValue.getName());
    }

    @Test
    public void testMatchingSalePrice(){

        Product actualValue = productService.createProduct(productDto);

        assertEquals(actualValue.getSalePrice(), expectedValue.getSalePrice());
    }

    @Test
    public void testMatchingDescription(){

        Product actualValue = productService.createProduct(productDto);

        assertEquals(actualValue.getDescription(), expectedValue.getDescription());
    }

    @Test
    public void testMatchingStorageProduct(){

        Product actualValue = productService.createProduct(productDto);

        assertEquals(actualValue.getStorage(), expectedValue.getStorage());
    }

    @Test
    public void testMatchingOriginProduct(){

        Product actualValue = productService.createProduct(productDto);

        assertEquals(actualValue.getOrigin(), expectedValue.getOrigin());
    }

    @Test
    public void testCreateProductException(){
        try {
            String param = null;
            Product actualValue = productService.createProduct(param);
        }catch (Exception ex){
            assertEquals(ex.getLocalizedMessage(), CONVERT_OBJECT_ERROR);
        }

    }

    private static void mockData(){

        BigDecimal salePriceProduct1 = new BigDecimal("999");
        BigDecimal marketPriceProduct1 = new BigDecimal("1099");
        List<String> productImages1 = Arrays.asList("image1", "image2", "image3");

        productDto = new ProductDto.ProductDtoBuilder(4, productName, salePriceProduct1, marketPriceProduct1, productImages1, "Black", 64)
                .setDescription("description")
                .setFactoryDate(LocalDateTime.now())
                .setOrigin("tiki.vn")
                .setDefaultImage("image1")
                .setWeight(0.15f).build();

        expectedValue = ProductDto.parseToProduct(productDto);

    }
}
