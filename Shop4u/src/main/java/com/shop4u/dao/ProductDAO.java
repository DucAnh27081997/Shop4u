package com.shop4u.dao;
import com.shop4u.entity.Product;

public interface ProductDAO {
	public void addProduct(Product product);
	public void updateProduct(Product product);
	public void deleteProduct(int id);
	public Product getProductById(int id);
	public java.util.List<Product> getAllProduct(String key,String value,int begin,int max);
	public long  getTotalRecords();
}
