package com.gigabytedx.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.gigabytedx.Main;
import com.gigabytedx.manipulateItems.AddWandMetaData;

public class GetWand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			return false;
		}
		
		Player player = (Player) sender;
		if(player.hasPermission("teleportwand.getwand")){
			player.sendMessage(ChatColor.GREEN + Main.pluginInstance.getName() + " - " + ChatColor.GOLD + "Giving you a wand");
			player.getInventory().setItem(8, getWand());
		}else{
			player.sendMessage(ChatColor.RED + "you do not have permission to perform this command!");
		}
		return false;
	}
	
	private ItemStack getWand(){
		ItemStack wand = new ItemStack(Material.BLAZE_ROD);
		wand.setItemMeta(AddWandMetaData.addWandMeta(wand.getItemMeta()));
		return wand;
	}
}
