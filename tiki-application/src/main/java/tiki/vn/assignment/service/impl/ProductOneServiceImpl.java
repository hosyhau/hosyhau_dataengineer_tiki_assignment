package tiki.vn.assignment.service.impl;

import tiki.vn.assignment.dto.ProductDto;
import tiki.vn.assignment.entity.Product;
import tiki.vn.assignment.exception.APIException;
import tiki.vn.assignment.service.ProductService;

import static tiki.vn.assignment.config.Constants.CONVERT_OBJECT_ERROR;

public class ProductOneServiceImpl implements ProductService<Product> {


    @Override
    public <E> Product createProduct(E param) {
        Product product = null;
        try {
            ProductDto productDto = (ProductDto)param;
            product = ProductDto.parseToProduct(productDto);
        }catch (Exception ex){
            throw new APIException(CONVERT_OBJECT_ERROR);
        }
        return product;
    }

}