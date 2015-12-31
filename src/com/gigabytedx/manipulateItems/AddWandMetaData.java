package com.gigabytedx.manipulateItems;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.inventory.meta.ItemMeta;

public class AddWandMetaData {
	public static ItemMeta addWandMeta(ItemMeta itemMeta) {
		
		itemMeta.setDisplayName(ChatColor.GREEN + "Magic Wand");
		List<String> lore = new ArrayList<String>();
		lore.add("Right click to teleport to a location!");
		itemMeta.setLore(lore);
		
		return itemMeta;
	}
		
	public static ItemMeta addBeaconMeta(ItemMeta itemMeta) {
			
			itemMeta.setDisplayName(ChatColor.GREEN + "Spawn");
			List<String> lore = new ArrayList<String>();
			lore.add("Click to teleport to spawn!");
			itemMeta.setLore(lore);
			
			return itemMeta;
		}
	public static ItemMeta addOakSaplingMeta(ItemMeta itemMeta) {
		
		itemMeta.setDisplayName(ChatColor.GREEN + "Wilderness");
		List<String> lore = new ArrayList<String>();
		lore.add("Click to teleport to random place in the near by wilderness");
		itemMeta.setLore(lore);
		
		return itemMeta;
	}

	public static ItemMeta addBedMeta(ItemMeta itemMeta) {
		itemMeta.setDisplayName(ChatColor.GREEN + "Home");
		List<String> lore = new ArrayList<String>();
		lore.add("Right click to set home teleport");
		lore.add("Left click to teleport back home");
		itemMeta.setLore(lore);
		
		return itemMeta;
	}
}
