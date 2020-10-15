package com.shop4u.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		List<ProductDTO> lstProduct = productService.getAllProduct(null,null,0,10);
		return lstProduct;
	}
	
	@RequestMapping(value = "/ProductByParameters", method = RequestMethod.POST)
	@ResponseBody
	public List<ProductDTO> ProductByParameters(@RequestParam(value = "key") String key,@RequestParam(value = "value") String value,
			@RequestParam(value = "begin") int begin,
			@RequestParam(value = "max") int max) {
		List<ProductDTO> lstProduct = productService.getAllProduct(key,value,begin,max);
		return lstProduct;
	}
	
	@RequestMapping(value = "/getTotalRecords", method = RequestMethod.GET)
	@ResponseBody
	public BaseData getTotalRecords() {		
		List<ProductDTO> lstProduct = productService.getAllProduct(null,null,0,10);
		BaseData map = new BaseData();
		map.setLst(lstProduct);
		map.setLenght(productService.getTotalRecords());
		return map;
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

class BaseData{
	private List<ProductDTO> lst;
	private long lenght;
	public List<ProductDTO> getLst() {
		return lst;
	}
	public void setLst(List<ProductDTO> lst) {
		this.lst = lst;
	}
	public long getLenght() {
		return lenght;
	}
	public void setLenght(long lenght) {
		this.lenght = lenght;
	}
	
}
