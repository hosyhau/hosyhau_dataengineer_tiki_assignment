package tiki.vn.assignment.provider;

import tiki.vn.assignment.config.ProductType;
import tiki.vn.assignment.exception.APIException;
import tiki.vn.assignment.service.ProductService;
import tiki.vn.assignment.service.impl.ProductCombinationServiceImpl;
import tiki.vn.assignment.service.impl.ProductOneServiceImpl;

import static tiki.vn.assignment.config.Constants.PRODUCT_TYPE_ERROR;

public class FactoryProvider {

    public static ProductService getProductService(ProductType productType){

        ProductService productService = null;
        try {

            switch (productType){
                case ONE:
                    productService =  new ProductOneServiceImpl();
                    break;
                case COMBINATION:
                    productService = new ProductCombinationServiceImpl();
                    break;
            }
        }catch (Exception ex){
            throw new APIException(PRODUCT_TYPE_ERROR);
        }

        return productService;
    }
}
