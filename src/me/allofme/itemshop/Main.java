package me.allofme.itemshop;

import org.bukkit.plugin.java.JavaPlugin;

import me.allofme.itemshop.commands.ItemShopCommand;
import me.allofme.itemshop.data.Config;
import me.allofme.itemshop.data.DataManager;
import me.allofme.itemshop.data.FileManager;

public class Main extends JavaPlugin {

	private static Main i;
	
	public static Main getInst() {
		return i;
	}
	
	public void onEnable() {
		i=this;
		getCommand("itemshop").setExecutor(new ItemShopCommand());
		FileManager.checkFiles();
		DataManager.loadData();
		Config.reloadConfig();
	}
	
}
