package com.shop4u.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop4u.dao.Part1DAO;
import  com.shop4u.entity.Part1;
import com.shop4u.service.Part1Service;
@Service
public class Part1ServiceImpl implements Part1Service {

	@Autowired
	Part1DAO part1DAO;
	
	@Override
	public void addPart1(Part1 x) {
		part1DAO.addPart1(x);
	}

	@Override
	public void updatePart1(Part1 x) {
		part1DAO.updatePart1(x);
		
	}

	@Override
	public void deletePart1(int id) {
		try {
			if(part1DAO.getPart1ById(id)!=null) {
				part1DAO.deletePart1(id);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}

	@Override
	public Part1 getPart1ById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Part1> getAllPart1(int idTest) {
		List<Part1> lst = part1DAO.getAllPart1(idTest);
		return lst;
	}

	
}
