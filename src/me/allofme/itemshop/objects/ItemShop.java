package me.allofme.itemshop.objects;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.ItemStack;

public class ItemShop {
	
	private String name;
	private List<String> message;
	private String command;
	private ItemStack item;
	
	public ItemShop(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getMessage() {
		if(this.message == null) return new ArrayList<String>(message);
		return message;
	}
	public void setMessage(List<String> message) {
		this.message = message;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}

	public ItemStack getItem() {
		return item;
	}

	public void setItem(ItemStack item) {
		this.item = item;
	}
	

}
