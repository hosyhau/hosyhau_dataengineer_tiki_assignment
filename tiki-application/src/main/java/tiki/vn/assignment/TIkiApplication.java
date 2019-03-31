package tiki.vn.assignment;

import tiki.vn.assignment.config.ProductType;
import tiki.vn.assignment.dto.ProductDto;
import tiki.vn.assignment.entity.Product;
import tiki.vn.assignment.provider.FactoryProvider;
import tiki.vn.assignment.repository.ProductRepository;
import tiki.vn.assignment.service.ProductService;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class TIkiApplication {

    public static void main(String[] args) {

        ProductService productOneService = FactoryProvider.getProductService(ProductType.ONE);
        ProductService productCombineService = FactoryProvider.getProductService(ProductType.COMBINATION);
        ProductRepository productRepository = new ProductRepository();

        ProductDto productDtoTest1 = productRepository.createProductDtoForTest1();
        ProductDto productDtoTest2 = productRepository.createProductDtoForTest2();
        List<ProductDto> productDtosTest3 = productRepository.createProductDtoForTest3();

        Product productTest1 = (Product) productOneService.createProduct(productDtoTest1);
        System.out.println("Test 1 = "+productTest1);

        Product productTest2 = (Product) productOneService.createProduct(productDtoTest2);
        System.out.println("Test 2 = "+productTest2);

        Map<String, Set<Product>> productTest3 = (Map<String, Set<Product>>) productCombineService.createProduct(productDtosTest3);
        System.out.println("Test 3 = "+productTest3);
    }
}
