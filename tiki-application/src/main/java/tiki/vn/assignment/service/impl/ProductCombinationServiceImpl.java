package tiki.vn.assignment.service.impl;

import tiki.vn.assignment.dto.ProductDto;
import tiki.vn.assignment.entity.Product;
import tiki.vn.assignment.exception.APIException;
import tiki.vn.assignment.service.ProductService;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.stream.Collectors.*;
import static tiki.vn.assignment.config.Constants.CONVERT_LIST_ERROR;

public class ProductCombinationServiceImpl implements ProductService<Map<String, Set<Product>>> {


    @Override
    public <E> Map<String, Set<Product>> createProduct(E param) {

        Map<String, Set<Product>> map = null;
        try {
            map = new ConcurrentHashMap<>();
            List<ProductDto> products  = (List<ProductDto>)param;

            map = products.stream().collect(
                    groupingBy(ProductDto::getName,
                            mapping(ProductDto::parseToProduct,
                                    toSet())));
        }catch (Exception ex){
            throw  new APIException(CONVERT_LIST_ERROR);
        }
        return map;

    }
}
