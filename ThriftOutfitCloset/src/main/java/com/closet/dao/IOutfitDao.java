package com.closet.dao;

import java.util.List;

import com.closet.exceptions.OutfitNotFoundException;
import com.closet.model.Outfit;

public interface IOutfitDao {
	
	List<Outfit> findAll();
	void addOutfit(Outfit outfit) ;
	void updateOutfit(int outfitId, String outfitOccasion);
	void deleteOutfit(int outfitId) ;
	List<Outfit> findByOutfitName (String outfitName)throws OutfitNotFoundException;
	List<Outfit> findByOutfitColor (String outfitColor) throws OutfitNotFoundException;
	List<Outfit> findByOutfitPriceMoreThan(double outfitPrice) throws OutfitNotFoundException;
	List<Outfit> findByAnyOcassion(String outfitName,String outfitOccasion) throws OutfitNotFoundException;
	void deleteFromOutfit(int outfitId);
	double calcRevenue();
	List<Outfit> findAllSoldOutfits();
	

}
