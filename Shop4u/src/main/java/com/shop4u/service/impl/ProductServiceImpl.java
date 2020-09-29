package com.shop4u.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  com.shop4u.entity.Product;
import com.shop4u.Model.ProductDTO;
import com.shop4u.dao.ProductDAO;
import com.shop4u.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDAO ProductDAO;
	
	@Override
	public void addProduct(ProductDTO x) {
		Product product = new Product();
		
		product.setName(x.getName());
		product.setImg(x.getImg());
		product.setDetail(x.getDetail());
		product.setCost(x.getCost());
		
		ProductDAO.addProduct(product);
	}

	@Override
	public void updateProduct(ProductDTO x) {
		Product product = new Product();
		product.setId(x.getId());
		product.setName(x.getName());
		product.setImg(x.getImg());
		product.setDetail(x.getDetail());
		product.setCost(x.getCost());
		
		ProductDAO.updateProduct(product);
	}

	@Override
	public void deleteProduct(int id) {
		
		ProductDAO.deleteProduct(id);
	}

	
	@Override
	public ProductDTO getProductById(int id) {

		Product product = ProductDAO.getProductById(id);
		if(product!=null) {
			ProductDTO x = new ProductDTO();
			x.setId(product.getId());
			x.setCost(product.getCost());
			x.setName(product.getName());
			x.setImg(product.getImg());	
			x.setDetail(product.getDetail());
			return x;
		}
		return null;
	}

	@Override
	public List<ProductDTO> getAllProduct() {
		List<Product> lst = ProductDAO.getAllProduct();
		List<ProductDTO> result = new ArrayList<ProductDTO>();
		for (Product item : lst) {
			
			ProductDTO x = new ProductDTO();
			x.setId(item.getId());
			x.setCost(item.getCost());
			x.setName(item.getName());
			x.setImg(item.getImg());		
			x.setDetail(item.getDetail());
			result.add(x);
		}
		return result;
	}

}
