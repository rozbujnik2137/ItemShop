package me.allofme.itemshop.data;

import org.bukkit.configuration.file.FileConfiguration;

import me.allofme.itemshop.Main;

public class Config {
	
	public static String permission;
	public static String nopermission;
	public static String usage;
	
	
	public static void reloadConfig() {
		FileConfiguration cfg = Main.getInst().getConfig();
		permission = cfg.getString("permission");
		nopermission = cfg.getString("nopermission");
		usage = cfg.getString("usage");
		Main.getInst().saveConfig();
	}

}
