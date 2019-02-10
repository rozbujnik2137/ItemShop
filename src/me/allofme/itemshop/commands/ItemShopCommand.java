package me.allofme.itemshop.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.allofme.itemshop.data.Config;
import me.allofme.itemshop.objects.ItemShop;
import me.allofme.itemshop.utils.ChatUtil;
import me.allofme.itemshop.utils.ItemshopUtils;

public class ItemShopCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String l, String[] args) {
		if(!sender.hasPermission(Config.permission)) {
			ChatUtil.send(sender, Config.nopermission);
			return true;
		}
		if(args.length != 2) {
			ChatUtil.send(sender, Config.usage.replace("{list}", ChatUtil.toString(ItemshopUtils.toList(), true)));
			return true;
		}
		if(ItemshopUtils.get(args[0]) == null) {
			ChatUtil.send(sender, "&cNie ma tego w sklepie!");
			return true;
		}
		ItemShop is = ItemshopUtils.get(args[0]);
		if(Bukkit.getPlayer(args[1]) == null) {
			ChatUtil.send(sender, "&cNie ma takiego gracza!");
			return true;
		}
		Player p = Bukkit.getPlayer(args[1]);
		for(String s : is.getMessage()) {
			ChatUtil.broadcast(s.replace("{PLAYER}", p.getName()));
		}
		Bukkit.dispatchCommand(Bukkit.getConsoleSender(), is.getCommand().replace("{PLAYER}", p.getName()));
		if(is.getItem() !=null) {
			ItemStack itemstack = is.getItem();
			p.getInventory().addItem(itemstack);
		}
		
		return true;
	}

}
