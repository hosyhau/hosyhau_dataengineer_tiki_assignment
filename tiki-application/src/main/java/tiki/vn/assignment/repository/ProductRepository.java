package tiki.vn.assignment.repository;

import tiki.vn.assignment.dto.ProductDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class ProductRepository {

    BigDecimal salePriceProduct1 = new BigDecimal("999");
    BigDecimal marketPriceProduct1 = new BigDecimal("1099");
    List<String> productImages1 = Arrays.asList("image1", "image2", "image3");

    BigDecimal salePriceProduct2 = new BigDecimal("950");
    BigDecimal marketPriceProduct2 = new BigDecimal("1050");
    List<String> productImages2 = Arrays.asList("image4", "image5", "image6");

    public ProductDto createProductDtoForTest1(){
        ProductDto product1 = new ProductDto.ProductDtoBuilder(1, "Iphone X 64Gb Black", salePriceProduct1, marketPriceProduct1, productImages1, "Black", 64)
                .setDefaultImage("image1")
                .setDescription("description")
                .setFactoryDate(LocalDateTime.now())
                .setOrigin("tiki.vn")
                .setWeight(0.15f).build();

        return product1;

    }

    public ProductDto createProductDtoForTest2(){
        ProductDto product2 = new ProductDto.ProductDtoBuilder(2, "Iphone X 128Gb Yellow", salePriceProduct2, marketPriceProduct2, productImages2, "Yellow", 128)
                .setDefaultImage("image1")
                .setDescription("description")
                .setFactoryDate(LocalDateTime.now())
                .setOrigin("tiki.vn")
                .setWeight(0.15f).build();

        return product2;
    }

    public List<ProductDto> createProductDtoForTest3(){

        ProductDto product3 = new ProductDto.ProductDtoBuilder(4, "Iphone X", salePriceProduct1, marketPriceProduct1, productImages1, "Black", 64)
                .setDefaultImage("image1")
                .setDescription("description")
                .setFactoryDate(LocalDateTime.now())
                .setOrigin("tiki.vn")
                .setWeight(0.15f).build();

        ProductDto product4 = new ProductDto.ProductDtoBuilder(5, "Iphone X", salePriceProduct2, marketPriceProduct2, productImages2, "Yellow", 128)
                .setDefaultImage("image1")
                .setDescription("description")
                .setFactoryDate(LocalDateTime.now())
                .setOrigin("tiki.vn")
                .setWeight(0.15f).build();

        List<ProductDto> productDtos = Arrays.asList(product3, product4);

        return productDtos;
    }
}
