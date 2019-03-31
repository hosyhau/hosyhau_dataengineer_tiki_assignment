package tiki.vn.assignment.service.impl;

import org.junit.BeforeClass;
import org.junit.Test;
import tiki.vn.assignment.config.ProductType;
import tiki.vn.assignment.provider.FactoryProvider;
import tiki.vn.assignment.service.ProductService;

import static org.junit.Assert.assertEquals;
import static tiki.vn.assignment.config.Constants.PRODUCT_TYPE_ERROR;


public class FactoryProviderTest {


    @BeforeClass
    public static void setUp(){

    }

    @Test
    public void testGetProductServiceReturnProductOneImpl(){
        ProductService actual = FactoryProvider.getProductService(ProductType.ONE);
        assertEquals(actual.getClass(), ProductOneServiceImpl.class);
    }

    @Test
    public void testGetProductServiceReturnProductCombinationImpl(){
        ProductService actual = FactoryProvider.getProductService(ProductType.COMBINATION);
        assertEquals(actual.getClass(), ProductCombinationServiceImpl.class);
    }

    @Test
    public void testGetProductServiceException(){
        try {
            ProductService actual = FactoryProvider.getProductService(null);
        }catch (Exception ex){
            assertEquals(ex.getLocalizedMessage(), PRODUCT_TYPE_ERROR);

        }

    }
}
