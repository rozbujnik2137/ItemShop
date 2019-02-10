package me.allofme.itemshop.data;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

import me.allofme.itemshop.Main;

public class FileManager {
	
	private static File dataFolder = Main.getInst().getDataFolder();
	private static File cfgFile = new File(dataFolder, "config.yml");
	private static File itemshop = new File(dataFolder, "itemshop.yml");
	private static YamlConfiguration itemshops;
	
	
	public static void checkFiles() {
		if(!dataFolder.exists()) dataFolder.mkdir();
		if(!cfgFile.exists()) Main.getInst().saveDefaultConfig();
		if(!itemshop.exists()) Main.getInst().saveResource("itemshop.yml", true);
		itemshops = YamlConfiguration.loadConfiguration(itemshop);
	}
	
	public static YamlConfiguration getItemShop() {
		return itemshops;
	}

}
