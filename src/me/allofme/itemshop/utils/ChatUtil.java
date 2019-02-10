package me.allofme.itemshop.utils;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatUtil {
	
	
	public static String color(String text) {
		return ChatColor.translateAlternateColorCodes('&', text);
	}
	
	public static void send(CommandSender sender, String text) {
		sender.sendMessage(color(text));
	}
	
	public static void send(Player p, String text) {
		p.sendMessage(color(text));
	}
	
	public static void broadcast(String text) {
		Bukkit.broadcastMessage(color(text));
	}
	
	public static void log(String text) {
		Bukkit.getConsoleSender().sendMessage(color(text));
	}
	
	public static String toString(List<String> list, boolean send) {
		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			sb.append(s);
			sb.append(',');
			if (send)
				sb.append(' ');
		}
		String s = sb.toString();
		if (send)
			if (s.length() > 2)
				s = s.substring(0, s.length() - 2);
			else if (s.length() > 1)
				s = s.substring(0, s.length() - 1);
		return s;
	}
	
	

}
