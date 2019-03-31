package tiki.vn.assignment.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Product implements Serializable {

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

    public Product(Integer id, String name, BigDecimal salePrice, BigDecimal marketPrice, List<String> images, String defaultImage, String color, String description, String origin, LocalDateTime factoryDate, Float weight, Integer storage) {
        this.id = id;
        this.name = name;
        this.salePrice = salePrice;
        this.marketPrice = marketPrice;
        this.images = images;
        this.defaultImage = defaultImage;
        this.color = color;
        this.description = description;
        this.origin = origin;
        this.factoryDate = factoryDate;
        this.weight = weight;
        this.storage = storage;
    }

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getDefaultImage() {
        return defaultImage;
    }

    public void setDefaultImage(String defaultImage) {
        this.defaultImage = defaultImage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public LocalDateTime getFactoryDate() {
        return factoryDate;
    }

    public void setFactoryDate(LocalDateTime factoryDate) {
        this.factoryDate = factoryDate;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "[id = "+id+", name = "+name+", sale price = "+salePrice+", market price = "+marketPrice+",color = "+color+", storage = "+storage+"\n" +
                ",description = "+description+", origin = "+origin+", factory date = "+factoryDate.toString()+", weight = "+weight+"]";
    }
}
