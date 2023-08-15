package com.closet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.closet.exceptions.OutfitNotFoundException;
import com.closet.model.Outfit;
import com.closet.util.DbConnection;
import com.closet.util.Queries;


public class OutfitDaoImpl implements IOutfitDao {

	@Override
	public List<Outfit> findAll() {
		List<Outfit> outfits = new ArrayList<Outfit>();
        try (Connection connection = DbConnection.openConnection();
           PreparedStatement statement = connection.prepareStatement(Queries.QUERYALL);) {
        	ResultSet result = statement.executeQuery();
               while (result.next()) {
            	   Outfit outfit = new Outfit();   
            	   int outfitId = result.getInt("outfitId");
            	   String outfitName = result.getString("outfitName");
            	   String outfitColor = result.getString("outfitColor");
            	   double outfitPrice = result.getDouble("outfitPrice");
            	   String outfitOccasion = result.getString("outfitOccasion");
            	   outfit.setOutfitId(outfitId);
            	   outfit.setOutfitName(outfitName);
            	   outfit.setOutfitColor(outfitColor);
            	   outfit.setOutfitPrice(outfitPrice);
            	   outfit.setOutfitOccasion(outfitOccasion);
            	   outfits.add(outfit);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return outfits;
	}

	@Override
	public void addOutfit(Outfit outfit) {
		 try(Connection connection = DbConnection.openConnection();
		    		PreparedStatement statement = connection.prepareStatement(Queries.INSERTQUERY);){
		    	     statement.setInt(1, outfit.getOutfitId());
		    	     statement.setString(2,outfit.getOutfitName());
		    	     statement.setString(3,outfit.getOutfitColor());
		    	     statement.setDouble(4,outfit.getOutfitPrice());
		    	     statement.setString(5,outfit.getOutfitOccasion());
		    	       
		    	     statement.execute();		
		    		}catch(SQLException e) {
		    			e.printStackTrace();
		    		}
		
	}

	@Override
	public void updateOutfit(int outfitId, String outfitOccasion) {
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.UPDATEQUERY);) {
			statement.setString(1,outfitOccasion);
			statement.setInt(2,outfitId);
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOutfit(int outfitId) {
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.DELETEQUERY);) {
			statement.setDouble(1, outfitId);
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Outfit> findByOutfitName(String outfitName) {
		List<Outfit> outfits = new ArrayList<>();
        try (Connection connection = DbConnection.openConnection();
           PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYOUTFITNAME);) {
        	statement.setString(1, "%" + outfitName + "%");
        	ResultSet result = statement.executeQuery();
               while (result.next()) {
            	   Outfit outfit = new Outfit();
            	   
            	   int outfitId = result.getInt("outfitId");
            	   String outfitName1 = result.getString("outfitName");
            	   String outfitColor = result.getString("outfitColor");
            	   double outfitPrice = result.getDouble("outfitPrice");
            	   String  outfitOccasion = result.getString("outfitOccasion");
            	   outfit.setOutfitId(outfitId);
            	   outfit.setOutfitName(outfitName1);
            	   outfit.setOutfitColor(outfitColor);
            	   outfit.setOutfitPrice(outfitPrice);
            	   outfit.setOutfitOccasion(outfitOccasion);
            	   outfits.add(outfit);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return outfits;
	}

	@Override
	public List<Outfit> findByOutfitColor(String outfitColor) throws OutfitNotFoundException {
		List<Outfit> outfits = new ArrayList<>();
        try (Connection connection = DbConnection.openConnection();
           PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYOUTFITCOLOR);) {
        	statement.setString(1, "%" + outfitColor + "%");
        	ResultSet result = statement.executeQuery();
               while (result.next()) {
            	   Outfit outfit = new Outfit();
            	   
            	   int outfitId = result.getInt("outfitId");
            	   String outfitName1 = result.getString("outfitName");
            	   String outfitColor1 = result.getString("outfitColor");
            	   double outfitPrice = result.getDouble("outfitPrice");
            	   String  outfitOccasion = result.getString("outfitOccasion");
            	   outfit.setOutfitId(outfitId);
            	   outfit.setOutfitName(outfitName1);
            	   outfit.setOutfitColor(outfitColor1);
            	   outfit.setOutfitPrice(outfitPrice);
            	   outfit.setOutfitOccasion(outfitOccasion);
            	   outfits.add(outfit);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return outfits;
	}

	@Override
	public List<Outfit> findByOutfitPriceMoreThan(double outfitPrice) throws OutfitNotFoundException {
		List<Outfit> outfits = new ArrayList<>();
        try (Connection connection = DbConnection.openConnection();
           PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYPRICEMORETHAN);) {
        	statement.setDouble(1,outfitPrice);
        	ResultSet result = statement.executeQuery();
               while (result.next()) {
            	   Outfit outfit = new Outfit();
            	   
            	   int outfitId = result.getInt("outfitId");
            	   String outfitName1 = result.getString("outfitName");
            	   String outfitColor = result.getString("outfitColor");
            	   double outfitPrice1 = result.getDouble("outfitPrice");
            	   String  outfitOccasion = result.getString("outfitOccasion");
            	   outfit.setOutfitId(outfitId);
            	   outfit.setOutfitName(outfitName1);
            	   outfit.setOutfitColor(outfitColor);
            	   outfit.setOutfitPrice(outfitPrice1);
            	   outfit.setOutfitOccasion(outfitOccasion);
            	   outfits.add(outfit);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return outfits;
	}
	

	@Override
	public List<Outfit> findByAnyOcassion(String outfitName, String outfitOccasion) throws OutfitNotFoundException {
		List<Outfit> outfits = new ArrayList<>();
        try (Connection connection = DbConnection.openConnection();
           PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYOCCASIONANDNAME);) {
        	statement.setString(1,outfitName);
        	statement.setString(2, outfitOccasion);
        	ResultSet result = statement.executeQuery();
               while (result.next()) {
            	   Outfit outfit = new Outfit();
            	   
            	   int outfitId = result.getInt("outfitId");
            	   String outfitName1 = result.getString("outfitName");
            	   String outfitColor1 = result.getString("outfitColor");
            	   double outfitPrice = result.getDouble("outfitPrice");
            	   String  outfitOccasion1 = result.getString("outfitOccasion");
            	   outfit.setOutfitId(outfitId);
            	   outfit.setOutfitName(outfitName1);
            	   outfit.setOutfitColor(outfitColor1);
            	   outfit.setOutfitPrice(outfitPrice);
            	   outfit.setOutfitOccasion(outfitOccasion1);
            	   outfits.add(outfit);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return outfits;
	}

	@Override
	public void deleteFromOutfit(int outfitId) {
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement1 = connection.prepareStatement(Queries.INSERTSOLDQUERY);
				PreparedStatement statement2 = connection.prepareStatement(Queries.DELETEQUERY);) {
		    statement1.setDouble(1, outfitId);
			statement1.execute();
			statement2.setDouble(1, outfitId);
			statement2.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public double calcRevenue() {
		double revenue =0;
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.REVENUEQUERY);) {
			ResultSet result =statement.executeQuery();
			result.next();
			revenue=result.getDouble("revenue");
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return revenue;
	}

	@Override
	public List<Outfit> findAllSoldOutfits() {
		List<Outfit> outfits = new ArrayList<Outfit>();
        try (Connection connection = DbConnection.openConnection();
           PreparedStatement statement = connection.prepareStatement(Queries.QUERYSOLDOUTFIT);) {
        	ResultSet result = statement.executeQuery();
               while (result.next()) {
            	   Outfit outfit = new Outfit();   
            	   int outfitId = result.getInt("outfitId");
            	   String outfitName = result.getString("outfitName");
            	   String outfitColor = result.getString("outfitColor");
            	   double outfitPrice = result.getDouble("outfitPrice");
            	   String  outfitOccasion = result.getString("outfitOccasion");
            	   outfit.setOutfitId(outfitId);
            	   outfit.setOutfitName(outfitName);
            	   outfit.setOutfitColor(outfitColor);
            	   outfit.setOutfitPrice(outfitPrice);
            	   outfit.setOutfitOccasion(outfitOccasion);
            	   outfits.add(outfit);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return outfits;
	}

}
