package tiki.vn.assignment.repository;

import org.junit.BeforeClass;
import org.junit.Test;
import tiki.vn.assignment.dto.ProductDto;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProductRepositoryTest {

    private static ProductRepository productRepository = null;


    @BeforeClass
    public static void setUp(){
        productRepository = new ProductRepository();
    }


    @Test
    public void testCreateProductDtoForTest1NotNull(){

        ProductDto actual = productRepository.createProductDtoForTest1();
        assertNotNull(actual);
        assertEquals(actual.getColor(), "Black");
        assertEquals(actual.getName(), "Iphone X 64Gb Black");
    }

    @Test
    public void testCreateProductDtoForTest2NotNull(){

        ProductDto actual = productRepository.createProductDtoForTest2();
        assertNotNull(actual);
        assertEquals(actual.getColor(), "Yellow");
        assertEquals(actual.getName(), "Iphone X 128Gb Yellow");
    }

    @Test
    public void testCreateProductDtoForTest3NotNull(){
        List<ProductDto> actual = productRepository.createProductDtoForTest3();
        assertNotNull(actual);
    }

}
