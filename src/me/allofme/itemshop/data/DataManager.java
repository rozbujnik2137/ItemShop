package me.allofme.itemshop.data;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.allofme.itemshop.objects.ItemShop;
import me.allofme.itemshop.utils.ItemshopUtils;
import net.md_5.bungee.api.ChatColor;

public class DataManager {
	
	
	public static void loadData() {
		ConfigurationSection cs1 = FileManager.getItemShop().getConfigurationSection("itemshop");
		for(String s : cs1.getKeys(false)) {
			ConfigurationSection cs = cs1.getConfigurationSection(s);
			ItemShop is = new ItemShop(s);
			is.setCommand(cs.getString("command"));
			is.setMessage(cs.getStringList("message"));
			if(cs.getBoolean("useitemstack") == true) {
				ItemStack itemstack = new ItemStack(Material.matchMaterial(cs.getString("material")), cs.getInt("amount"));
				ItemMeta im = itemstack.getItemMeta();
				im.setDisplayName(ChatUstil.color(cs.getString("displayname")));
				List<String> lore = cs.getStringList("lore");
				lore.replaceAll(string -> ChatColor.translateAlternateColorCodes('&', string));
				im.setLore(lore);
				itemstack.setItemMeta(im);
				is.setItem(itemstack);
			}
			ItemshopUtils.addItemShop(is);
		}
	}

}
