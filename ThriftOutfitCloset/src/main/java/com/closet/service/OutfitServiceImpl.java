package com.closet.service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import com.closet.dao.IOutfitDao;
import com.closet.dao.OutfitDaoImpl;
import com.closet.exceptions.OutfitNotFoundException;
import com.closet.model.Outfit;



public class OutfitServiceImpl implements IOutfitService{
	IOutfitDao outfitdao = new OutfitDaoImpl();

	@Override
	public List<Outfit> getAll() {
		return outfitdao.findAll();
	}

	@Override
	public void addOutfit(Outfit outfit) {
		outfitdao.addOutfit(outfit);
		
	}

	@Override
	public void updateOutfit(int outfitId, String outfitOccasion) {
		outfitdao.updateOutfit(outfitId, outfitOccasion);
		
	}

	@Override
	public void deleteOutfit(int outfitId) {
		outfitdao.deleteOutfit(outfitId);
		
	}

	@Override
	public List<Outfit> getByOutfitName(String outfitName)throws OutfitNotFoundException {
		List<Outfit> outfits = outfitdao.findByOutfitName(outfitName);
		if((outfits).isEmpty())
			throw new OutfitNotFoundException("Outfits not found with this name :( ");
		return outfits.stream()
				.sorted((d1,d2)->d1.getOutfitName().compareTo(d2.getOutfitName()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Outfit> getByOutfitColor(String outfitColor) throws OutfitNotFoundException {
		List<Outfit> outfits = outfitdao.findByOutfitColor(outfitColor);
		if((outfits).isEmpty())
			throw new OutfitNotFoundException("Outfits not found with this color :( ");
		return outfits.stream()
				.sorted((d1,d2)->d1.getOutfitColor().compareTo(d2.getOutfitColor()))
				.collect(Collectors.toList());
	}
	@Override
	public List<Outfit> getByOutfitPriceMoreThan(double outfitPrice) throws OutfitNotFoundException {
		List<Outfit> outfits = outfitdao.findByOutfitPriceMoreThan(outfitPrice);
		if((outfits).isEmpty())
			throw new OutfitNotFoundException("Outfits not found with this price range :( ");
		return outfits.stream()
				.sorted((d1,d2)->d1.getOutfitName().compareTo(d2.getOutfitName()))
				.collect(Collectors.toList());	
			}




	@Override
	public List<Outfit> getByAnyOcassion(String outfitName, String outfitOccasion) throws OutfitNotFoundException {
		List<Outfit> outfits = outfitdao.findByAnyOcassion(outfitName, outfitOccasion);
		if((outfits).isEmpty())
			throw new OutfitNotFoundException("Outfits not found with this occasion:( ");
		return outfits.stream()
				.sorted((d1,d2)->d1.getOutfitName().compareTo(d2.getOutfitName()))
				.collect(Collectors.toList());		
	}

	@Override
	public void deleteFromOutfit(int outfitId) {
		outfitdao.deleteFromOutfit(outfitId);
	}

	@Override
	public double calcRevenue() {
		return outfitdao.calcRevenue();
	}

	@Override
	public List<Outfit> getAllSoldOutfits() {
		return outfitdao.findAllSoldOutfits();
	}

}
