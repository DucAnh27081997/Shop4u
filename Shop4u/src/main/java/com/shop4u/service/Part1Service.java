package com.shop4u.service;
import com.shop4u.entity.Part1;

public interface Part1Service {
	public void addPart1(Part1 x);

	public void updatePart1(Part1 x);

	public void deletePart1(int id);

	public Part1 getPart1ById(int id);

	public java.util.List<Part1> getAllPart1(int idPart1);
	
}
