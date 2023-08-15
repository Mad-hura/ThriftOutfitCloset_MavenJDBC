package com.closet.client;

import java.util.Scanner;

import com.closet.exceptions.OutfitNotFoundException;
import com.closet.model.Outfit;
import com.closet.service.IOutfitService;
import com.closet.service.OutfitServiceImpl;


public class Client {
	public static void main(String[] args) {
       
      
		IOutfitService outfitService = new OutfitServiceImpl();
	
		int outfitId;
		String outfitName;
	    String outfitColor;
	    double outfitPrice;
	    String outfitOccasion;
		Scanner scanner = new Scanner(System.in);

		System.out.println("--------------------------- Welcome to Thrifted Outfit Closet ------------------------------");
		System.out.println();
		System.out.println("You can manage your closet and sell your pre-owned clothes here!");
		System.out.println();
		try {
			while (true) {
				System.out.println("1.Search outfits in closet by name!!\n\n2.Search outfits in closet by color!!\n\n"
						+ "3.Search outfits in closet for a occassion or a season!!\n\n"
						+ "4.Update occasion of an outfit!!\n\n5.Show all outfits in closet!!\n\n6.Add new outfit to closet!!\n\n7.Delete an outfit!!\n\n"
						+ "8.Sell outfits!!\n\n9.Show sold outfits\n\n10.Show revenue earned by sold outfits:\n\n11.Exit!!\n");
				System.out.println("Enter your choice:");
				int choice = scanner.nextInt();
				scanner.nextLine();
				switch (choice) {
				case 1:
					System.out.println("Enter outfit name: ");
					outfitName= scanner.nextLine();
					try {
						outfitService.getByOutfitName(outfitName).forEach(System.out::println);
					} catch (OutfitNotFoundException e) {
						System.out.println(e.getMessage());
					}
					System.out.println();
					break;
				case 2:
					System.out.println("Enter outfit color: ");
					outfitColor = scanner.nextLine();
					try {
					  outfitService.getByOutfitColor(outfitColor).forEach(System.out::println);
					} catch (OutfitNotFoundException e) {
						System.out.println(e.getMessage());
					}
					System.out.println();
					break;
				
				case 3:
					System.out.println("Enter outfit name: ");
					outfitName = scanner.next();
					System.out.println("Enter outfit occassion/season: ");
					outfitOccasion= scanner.next();
					
					try {
						outfitService.getByAnyOcassion(outfitName, outfitOccasion).forEach(System.out::println);		
						} catch (OutfitNotFoundException e) {
						System.out.println(e.getMessage());
					}
					System.out.println();
					break;	
					
				case 4:
					System.out.print("Enter new outfit occasion/season : ");
					outfitOccasion= scanner.next();
					System.out.print("Enter outfit Id: ");
					outfitId = scanner.nextInt();
					outfitService.updateOutfit(outfitId, outfitOccasion);
					System.out.println();
					break;
				
					
				case 5:
					
					System.out.println("Outfits available: ");
					outfitService.getAll().forEach(System.out::println);
					System.out.println();
					break;
				case 6:
					System.out.println("Enter outfit details");
					System.out.print("OutfitId: ");
					outfitId = scanner.nextInt();
					System.out.print("OutfitName: ");
					outfitName = scanner.next();
					System.out.print("OutfitColor: ");
					outfitColor = scanner.next();
					System.out.print("OutfitPrice: ");
					outfitPrice = scanner.nextDouble();
					System.out.print("OutfitOccasion/season: ");
					outfitOccasion = scanner.next();
					outfitService.addOutfit(new Outfit(outfitId,outfitName,outfitColor,outfitPrice,outfitOccasion));
					System.out.println();
					break;
				case 7:
					System.out.print("Enter outfitId: ");
					outfitId = scanner.nextInt();
					outfitService.deleteOutfit(outfitId);
					System.out.println();
					break;
				case 8:
					System.out.println("Enter outfit price range you want to sell : ");
					outfitPrice = scanner.nextInt();
					try {
						outfitService.getByOutfitPriceMoreThan(outfitPrice).forEach(System.out::println);
						System.out.println("Do you want to sell the above products?");
						String sell = scanner.next();
						switch(sell) {
						case "yes":
							System.out.println("Enter the oufitId to sell:");
							int id= scanner.nextInt();
							outfitService.deleteFromOutfit(id);
							System.out.println("The above products sold !!! Outfits removed from closet!");
							break;
						case "no":
							System.out.println("NO products sold!");
							break;
						default:
							System.out.println("Invalid option");
							break;
						}
					} catch (OutfitNotFoundException e) {
						System.out.println(e.getMessage());
					}
					System.out.println();
					break;
				case 9:
					System.out.println("Sold Outfits:");
					outfitService.getAllSoldOutfits().forEach(System.out::println);
					System.out.println();
					break;
					
				case 10:
					System.out.println("Revenue of sold outfits:");
					System.out.println(outfitService.calcRevenue());
					break;
					
				case 11:
					System.out.println("Bye...");
					System.exit(0);
					break;	
					
				default:
					System.out.println("Invalid choice");
					System.out.println();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}

	}

}


