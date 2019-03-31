package tiki.vn.assignment.service;

public interface ProductService<T> {

    public <E> T createProduct(E param);
}
