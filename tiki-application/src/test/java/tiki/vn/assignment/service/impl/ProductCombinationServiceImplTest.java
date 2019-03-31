package tiki.vn.assignment.service.impl;

import org.junit.BeforeClass;
import org.junit.Test;
import tiki.vn.assignment.dto.ProductDto;
import tiki.vn.assignment.entity.Product;
import tiki.vn.assignment.exception.APIException;
import tiki.vn.assignment.service.ProductService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static tiki.vn.assignment.config.Constants.CONVERT_LIST_ERROR;

public class ProductCombinationServiceImplTest {

    private static ProductService<Map<String, Set<Product>>> productService = null;

    private static Map<String, Set<Product>> expectValue = null;

    private static List<ProductDto> productDtos = null;

    private static String productName = "Iphone X";

    @BeforeClass
    public static void setUp(){
        productService = new ProductCombinationServiceImpl();
        productDtos = new ArrayList<>();
        expectValue = new ConcurrentHashMap<>();
        mockData();
    }

    @Test
    public void testMatchingNameProduct(){

        Map<String, Set<Product>> actual = productService.createProduct(productDtos);

        assertEquals(actual.containsKey(productName), expectValue.containsKey(productName));
    }

    @Test
    public void testMatchingSizeOfSetProduct(){

        Map<String, Set<Product>> actual = productService.createProduct(productDtos);

        assertEquals(actual.get(productName).size(), expectValue.get(productName).size());
    }

    @Test
    public void testMatchingSalePriceIphoneX(){

        Map<String, Set<Product>> actual = productService.createProduct(productDtos);

        List<Product> productsActual = actual.get(productName).parallelStream().collect(Collectors.toList());

        assertEquals(productsActual.get(0).getSalePrice(), new BigDecimal("950"));
    }

    @Test
    public void testMatchingMarketPriceIphoneX(){

        Map<String, Set<Product>> actual = productService.createProduct(productDtos);

        List<Product> productsActual = actual.get(productName).parallelStream().collect(Collectors.toList());

        assertEquals(productsActual.get(0).getMarketPrice(), productDtos.get(0).getMarketPrice());
    }

    @Test
    public void testMatchingDescriptionIphoneX(){

        Map<String, Set<Product>> actual = productService.createProduct(productDtos);

        List<Product> productsActual = actual.get(productName).parallelStream().collect(Collectors.toList());

        assertEquals(productsActual.get(0).getDescription(), productDtos.get(0).getDescription());
    }

    @Test
    public void testMatchingOriginIphoneX(){

        Map<String, Set<Product>> actual = productService.createProduct(productDtos);

        List<Product> productsActual = actual.get(productName).parallelStream().collect(Collectors.toList());

        assertEquals(productsActual.get(0).getOrigin(), productDtos.get(0).getOrigin());
    }


    @Test
    public void testMatchingWeightIphoneX(){

        Map<String, Set<Product>> actual = productService.createProduct(productDtos);

        List<Product> productsActual = actual.get(productName).parallelStream().collect(Collectors.toList());

        assertEquals(productsActual.get(0).getWeight(), productDtos.get(0).getWeight());
    }

    @Test
    public void testCreatProductException(){

        try {
            String param = null;
            Map<String, Set<Product>> actual = productService.createProduct(param);
        }catch (APIException ex){
            assertEquals(ex.getLocalizedMessage(), CONVERT_LIST_ERROR);

        }
    }

    private static void mockData(){
        BigDecimal salePriceProduct1 = new BigDecimal("999");
        BigDecimal marketPriceProduct1 = new BigDecimal("1099");
        List<String> productImages1 = Arrays.asList("image1", "image2", "image3");

        BigDecimal salePriceProduct2 = new BigDecimal("950");
        BigDecimal marketPriceProduct2 = new BigDecimal("1050");
        List<String> productImages2 = Arrays.asList("image4", "image5", "image6");

        ProductDto productDto1 = new ProductDto.ProductDtoBuilder(4, productName, salePriceProduct1, marketPriceProduct1, productImages1, "Black", 64)
                .setDescription("description")
                .setFactoryDate(LocalDateTime.now())
                .setOrigin("tiki.vn")
                .setDefaultImage("image1")
                .setWeight(0.15f).build();

        ProductDto productDto2 = new ProductDto.ProductDtoBuilder(5, productName, salePriceProduct2, marketPriceProduct2, productImages2, "Yellow", 128)
                .setDescription("description")
                .setFactoryDate(LocalDateTime.now())
                .setOrigin("tiki.vn")
                .setDefaultImage("image1")
                .setWeight(0.15f).build();

        productDtos.add(productDto1);
        productDtos.add(productDto2);

        Product product1 = ProductDto.parseToProduct(productDto1);
        Product product2 = ProductDto.parseToProduct(productDto2);

        Set<Product> productSet = new HashSet<>();
        productSet.add(product1);
        productSet.add(product2);
        expectValue.put(productName, productSet);
    }


}
