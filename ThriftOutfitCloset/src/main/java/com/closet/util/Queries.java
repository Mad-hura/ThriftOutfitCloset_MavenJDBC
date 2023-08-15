package com.closet.util;

public class Queries {
	public static final String CREATEQUERY = "create table if not exists outfit(outfitId int primary key, "
			+ "outfitName varchar(50) not null, outfitColor varchar(20) not null, outfitPrice double,outfitOccasion varchar(50));";
	public static final String CREATESOLDQUERY = "create table if not exists soldOutfits(outfitId int primary key, "
			+ "outfitName varchar(50) not null, outfitColor varchar(20) not null, outfitPrice double,outfitOccasion varchar(50));";
	public static final String INSERTSOLDQUERY ="insert into soldOutfits(outfitId,outfitName,outfitColor,outfitPrice,outfitOccasion) select * from outfit where outfitId=?;";
	public static final String QUERYSOLDOUTFIT ="select * from soldOutfits ;";
	public static final String REVENUEQUERY = "select SUM(outfitPrice) as revenue from soldOutfits ;";
	public static final String INSERTQUERY = "insert into outfit(outfitId,outfitName,outfitColor,outfitPrice,outfitOccasion) values(?,?,?,?,?);";
	public static final String UPDATEQUERY = "update outfit set outfitOccasion=? where outfitId=?;";
	public static final String DELETEQUERY = "delete from outfit where outfitId=?;";
	public static final String QUERYALL = "select * from outfit;";
	public static final String QUERYBYOUTFITNAME = "select * from outfit where outfitName like CONCAT( '%',?,'%');";
	public static final String QUERYBYOUTFITCOLOR = "select * from outfit where outfitColor like CONCAT( '%',?,'%');";
	public static final String QUERYBYOCCASIONANDNAME = "select * from outfit where outfitName like CONCAT( '%',?,'%') and outfitOccasion=CONCAT(?);";	
	public static final String QUERYBYPRICEMORETHAN = "select * from outfit where outfitPrice>?;";
	
}
