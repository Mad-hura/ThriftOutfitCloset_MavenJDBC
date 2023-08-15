package com.closet.model;

public class Outfit {
	private Integer outfitId;
	private String outfitName;
	private String outfitColor;
	private double outfitPrice;
	private String outfitOccasion;
	
	public Outfit() {
		super();
	}

	

	public Outfit(Integer outfitId, String outfitName, String outfitColor, double outfitPrice, String outfitOccasion) {
		super();
		this.outfitId = outfitId;
		this.outfitName = outfitName;
		this.outfitColor = outfitColor;
		this.outfitPrice = outfitPrice;
		this.outfitOccasion = outfitOccasion;
	}

	public Integer getOutfitId() {
		return outfitId;
	}

	public void setOutfitId(Integer outfitId) {
		this.outfitId = outfitId;
	}

	public String getOutfitName() {
		return outfitName;
	}

	public void setOutfitName(String outfitName) {
		this.outfitName = outfitName;
	}

	public String getOutfitColor() {
		return outfitColor;
	}

	public void setOutfitColor(String outfitColor) {
		this.outfitColor = outfitColor;
	}

	public double getOutfitPrice() {
		return outfitPrice;
	}

	public void setOutfitPrice(double outfitPrice) {
		this.outfitPrice = outfitPrice;
	}

	public String getOutfitOccasion() {
		return outfitOccasion;
	}

	public void setOutfitOccasion(String outfitOccasion) {
		this.outfitOccasion = outfitOccasion;
	}

	@Override
	public String toString() {
		return "Outfit [outfitId=" + outfitId + ", outfitName=" + outfitName + ", outfitColor=" + outfitColor
				+ ", outfitPrice=" + outfitPrice + ", outfitOccasion=" + outfitOccasion + "]";
	}
	
	
	
}
	
