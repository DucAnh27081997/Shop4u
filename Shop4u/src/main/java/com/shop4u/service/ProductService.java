package com.shop4u.service;
import com.shop4u.Model.ProductDTO;

public interface ProductService {
	public void addProduct(ProductDTO x);

	public void updateProduct(ProductDTO x);

	public void deleteProduct(int id);

	public ProductDTO getProductById(int id);

	public java.util.List<ProductDTO> getAllProduct();
}
