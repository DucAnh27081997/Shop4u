package com.shop4u.Controller.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shop4u.Model.OderDTO;
import com.shop4u.Model.OderItemDTO;
import com.shop4u.Model.ProductDTO;
import com.shop4u.service.ProductService;

@Controller
public class CartContronller {
	
	@Autowired
	ProductService  productService;
	
	@RequestMapping(value = "cart/add-to-cart/{id}",method = RequestMethod.GET)
	public String AddToCart(HttpServletRequest request,@PathVariable(name = "id") int id,HttpSession session) {
		
		ProductDTO x = productService.getProductById(id);
		if(session.getAttribute("cart")==null) {
			OderDTO oderDTO = new OderDTO();
			// tao 1 item  trong gio hang moi voi so luong bang 1 
			OderItemDTO item = new OderItemDTO();
			item.setNumber(1);
			item.setProductDTO(x);
			
			List<OderItemDTO> listItem = new ArrayList<OderItemDTO>();
			listItem.add(item);
			
			// set list san pham 
			oderDTO.setList(listItem);
			
			session.setAttribute("cart",oderDTO);
			
		}
		else {
			
			OderDTO oderDTO = (OderDTO) session.getAttribute("cart");
			List<OderItemDTO> listItem =  oderDTO.getList();
			boolean flag = false;
			for (OderItemDTO item : listItem) {
				if(x.getId()==item.getProductDTO().getId()) {
					// truong hop co roi thi tang so luong				
					item.setNumber(item.getNumber()+1);
					flag = true;
				}			
			}
			
			if(!flag){
				// neu khong co trong cart thi them moi
				OderItemDTO item_new = new OderItemDTO();
				item_new.setNumber(1);
				item_new.setProductDTO(x);
				
				listItem.add(item_new);
				
				// set list san pham 
				oderDTO.setList(listItem);
			}
			session.setAttribute("cart",oderDTO);
			
		}
		return "redirect:../../cart/danh-sach-san-pham";
	}
	
	@RequestMapping(value = "cart/remove-product/{id}",method = RequestMethod.GET)
	public String ViewCart(HttpServletRequest request,HttpSession session,@PathVariable(name="id") int id) {
		
		ProductDTO x = productService.getProductById(id);
		if(session.getAttribute("cart")!=null) {
			OderDTO oderDTO = (OderDTO) session.getAttribute("cart");
			List<OderItemDTO> listItem =  oderDTO.getList();
			for (OderItemDTO item : listItem) {
				if(x.getId()==item.getProductDTO().getId()) {
					listItem.remove(item);	
					break;
				}			
			}
			oderDTO.setList(listItem);
			session.setAttribute("cart",oderDTO);
			request.setAttribute("oder", oderDTO);
			
		}
		
		return "redirect:../danh-sach-san-pham";
	}
	@RequestMapping(value = "cart/danh-sach-san-pham",method = RequestMethod.GET)
	public ModelAndView ViewCart(HttpServletRequest request,HttpSession session) {
		if(session.getAttribute("cart")!=null) {
			OderDTO oderDTO = (OderDTO) session.getAttribute("cart");
			request.setAttribute("oder", oderDTO);
		}
		request.setAttribute("title", "Gio Hang Cua Ban");
		return new ModelAndView("/web/Cart/cart");
	}
	
	@RequestMapping(value = "home/danh-sach-san-pham",method = RequestMethod.GET)
	public ModelAndView DanhSanhSanPham(HttpServletRequest request) {		
		List<ProductDTO> list = productService.getAllProduct(null,null,0,10);
		request.setAttribute("listProduc",list);	
		request.setAttribute("title", "Danh sach san pham");
		return new ModelAndView("web/Product/list");
	}
}
