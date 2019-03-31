package tiki.vn.assignment.dto;

import tiki.vn.assignment.entity.Product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ProductDto implements Serializable {


    private Integer id;

    private String name;

    private BigDecimal salePrice;

    private BigDecimal marketPrice;

    private List<String> images;

    private String defaultImage;

    private String color;

    private String description;

    private String origin;

    private LocalDateTime factoryDate;

    private Float weight;

    private Integer storage;



    private ProductDto(ProductDto.ProductDtoBuilder productBuilder){
        this.id = productBuilder.id;
        this.name = productBuilder.name;
        this.salePrice = productBuilder.salePrice;
        this.marketPrice = productBuilder.marketPrice;
        this.images = productBuilder.images;
        this.storage = productBuilder.storage;
        this.defaultImage = productBuilder.defaultImage;
        this.color = productBuilder.color;
        this.description = productBuilder.description;
        this.origin = productBuilder.origin;
        this.factoryDate = productBuilder.factoryDate;
        this.weight = productBuilder.weight;
    }

    public ProductDto() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public List<String> getImages() {
        return images;
    }

    public String getDefaultImage() {
        return defaultImage;
    }

    public String getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }

    public String getOrigin() {
        return origin;
    }

    public LocalDateTime getFactoryDate() {
        return factoryDate;
    }

    public Float getWeight() {
        return weight;
    }

    public Integer getStorage() {
        return storage;
    }

    public static Product parseToProduct(ProductDto productDto){

        Product product = new Product();
        product.setId(productDto.getId());
        product.setColor(productDto.getColor());
        product.setDefaultImage(productDto.getDefaultImage());
        product.setDescription(productDto.getDescription());
        product.setFactoryDate(productDto.getFactoryDate());
        product.setImages(productDto.getImages());
        product.setMarketPrice(productDto.getMarketPrice());
        product.setName(productDto.getName());
        product.setOrigin(productDto.getOrigin());
        product.setSalePrice(productDto.getSalePrice());
        product.setStorage(productDto.getStorage());
        product.setWeight(productDto.getWeight());

        return product;
    }

    public static class ProductDtoBuilder{

        private Integer id;

        private String name;

        private BigDecimal salePrice;

        private BigDecimal marketPrice;

        private List<String> images;

        private String color;

        private String description;

        private String origin;

        private LocalDateTime factoryDate;

        private Float weight;

        private String defaultImage;

        private Integer storage;

        public ProductDtoBuilder(Integer id, String name, BigDecimal salePrice, BigDecimal marketPrice, List<String> images, String color, Integer storage) {
            this.id = id;
            this.name = name;
            this.salePrice = salePrice;
            this.marketPrice = marketPrice;
            this.images = images;
            this.color = color;
            this.storage = storage;
        }


        public ProductDto.ProductDtoBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ProductDto.ProductDtoBuilder setOrigin(String origin) {
            this.origin = origin;
            return this;
        }

        public ProductDto.ProductDtoBuilder setFactoryDate(LocalDateTime factoryDate) {
            this.factoryDate = factoryDate;
            return this;
        }

        public ProductDto.ProductDtoBuilder setWeight(Float weight) {
            this.weight = weight;
            return this;
        }

        public ProductDto.ProductDtoBuilder setDefaultImage(String defaultImage) {
            this.defaultImage = defaultImage;
            return this;
        }

        public ProductDto build(){
            return new ProductDto(this);
        }
    }

}
