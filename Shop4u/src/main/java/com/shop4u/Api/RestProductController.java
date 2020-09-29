package com.shop4u.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop4u.Model.ProductDTO;
import com.shop4u.service.ProductService;

@RestController
@RequestMapping("/api")
public class RestProductController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/Product", method = RequestMethod.GET)
	@ResponseBody
	public List<ProductDTO> getAllProduct() {
		List<ProductDTO> lstProduct = productService.getAllProduct();
		return lstProduct;
	}

	@RequestMapping(value = "/Product/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ProductDTO getProductById(@PathVariable("id") int id) {
		ProductDTO product = productService.getProductById(id);
		if (product != null)
			return product;
		else
			return null;
	}

	@RequestMapping(value = "/Product/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String DeleteProductById(@PathVariable("id") int id) {
		ProductDTO product = productService.getProductById(id);
		if (product != null) {
			productService.deleteProduct(id);
			return "success";
		} else
			return "fail";
	}

	@RequestMapping(value = "/Product", method = RequestMethod.POST)
	@ResponseBody
	public String AddProduct(@RequestBody ProductDTO product) {
		try {
			productService.addProduct(product);
			return "success";
		} catch (Exception e) {
			return "fail: " + e.getMessage();
		}
	}

	@RequestMapping(value = "/Product", method = RequestMethod.PUT)
	@ResponseBody
	public String UpdateProduct(@RequestBody ProductDTO product) {
		try {
			if (productService.getProductById(product.getId()) != null) {
				productService.updateProduct(product);
				return "success";
			} else {
				return "fail: ko ton tai!";
			}
		} catch (Exception e) {
			return "fail: " + e.getMessage();
		}
	}

}
