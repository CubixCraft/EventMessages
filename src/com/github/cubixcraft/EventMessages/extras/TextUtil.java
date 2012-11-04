package com.github.cubixcraft.EventMessages.extras;

import org.bukkit.ChatColor;

public class TextUtil {
	public static String join(String[] arr, int start, int end, String delimeter) {
		String string = "";
		
		end = end > arr.length - 1 ? arr.length - 1 : end; 
		start = start > end ? 0 : start;
		
		for(int i = start; i <= end; i++) string += arr[i] + delimeter;
		string = string.substring(0, string.length() - delimeter.length());
		
		return string;
	}
	public static String join(String[] arr, String delimeter) {
		return join(arr, 0, arr.length - 1, delimeter);
	}
	public static String join(String[] arr, int start) {
		return join(arr, start, arr.length - 1, "");
	}
	public static String join(String[] arr, int start, String delimeter) {
		return join(arr, start, arr.length - 1, delimeter);
	}
	
	public static String format(String string) {
		string = string.replaceAll("&0", ChatColor.BLACK + "");
		string = string.replaceAll("&1", ChatColor.DARK_BLUE + "");
		string = string.replaceAll("&2", ChatColor.DARK_GREEN + "");
		string = string.replaceAll("&3", ChatColor.DARK_AQUA + "");
		string = string.replaceAll("&4", ChatColor.DARK_RED + "");
		string = string.replaceAll("&5", ChatColor.DARK_PURPLE + "");
		string = string.replaceAll("&6", ChatColor.GOLD + "");
		string = string.replaceAll("&7", ChatColor.GRAY + "");
		string = string.replaceAll("&8", ChatColor.DARK_GRAY + "");
		string = string.replaceAll("&9", ChatColor.BLUE + "");
		string = string.replaceAll("&a", ChatColor.GREEN + "");
		string = string.replaceAll("&b", ChatColor.AQUA + "");
		string = string.replaceAll("&c", ChatColor.RED + "");
		string = string.replaceAll("&d", ChatColor.LIGHT_PURPLE + "");
		string = string.replaceAll("&e", ChatColor.YELLOW + "");
		string = string.replaceAll("&f", ChatColor.WHITE + "");
		string = string.replaceAll("&k", ChatColor.MAGIC + "");
		string = string.replaceAll("&l", ChatColor.BOLD + "");
		string = string.replaceAll("&m", ChatColor.STRIKETHROUGH + "");
		string = string.replaceAll("&n", ChatColor.UNDERLINE + "");
		string = string.replaceAll("&r", ChatColor.RESET + "");
		return string;
	}
}
