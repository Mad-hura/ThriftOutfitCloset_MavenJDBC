package com.closet.service;

import java.util.List;

import com.closet.exceptions.OutfitNotFoundException;
import com.closet.model.Outfit;

public interface IOutfitService {
	
	List<Outfit> getAll();
	void addOutfit(Outfit outfit) ;
	void updateOutfit(int outfitId, String outfitOccasion);
	void deleteOutfit(int outfitId) ;
	List<Outfit> getByOutfitName (String outfitName)throws OutfitNotFoundException;
	List<Outfit> getByOutfitColor (String outfitColor) throws OutfitNotFoundException;
	List<Outfit> getByOutfitPriceMoreThan(double outfitPrice) throws OutfitNotFoundException;
	List<Outfit> getByAnyOcassion(String outfitName,String outfitOccasion) throws OutfitNotFoundException;
	void deleteFromOutfit(int outfitId);
	double calcRevenue();
	List<Outfit> getAllSoldOutfits();
	
	
	
	

}
