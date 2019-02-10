package me.allofme.itemshop.utils;

import java.util.ArrayList;
import java.util.List;

import me.allofme.itemshop.objects.ItemShop;

public class ItemshopUtils {
	
	private static ArrayList<ItemShop> itemshops = new ArrayList<>();
	
	public static ArrayList<ItemShop> getItemShops(){
		return itemshops;
	}
	
	public static void addItemShop(ItemShop is) {
		if(!itemshops.contains(is)) {
			itemshops.add(is);
		}
	}
	
	public static void removeItemShop(ItemShop is) {
		if(itemshops.contains(is)) {
			itemshops.remove(is);
		}
	}
	
	public static ItemShop get(String name) {
		for(ItemShop shops : itemshops) {
			if(shops.getName().equals(name)) {
				return shops;
			}
		}
		return null;
	}
	
	public static List<String> toList(){
		List<String> lista = new ArrayList<>();
		for(ItemShop is : itemshops) {
			lista.add(is.getName());
		}
		return lista;
	}

}
