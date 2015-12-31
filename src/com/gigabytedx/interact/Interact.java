package com.gigabytedx.interact;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.gigabytedx.Main;
import com.gigabytedx.manipulateItems.AddWandMetaData;

public class Interact implements Listener {

	@EventHandler
	public void playerInteract(PlayerInteractEvent event) {
		if ((event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK))
				&& event.getPlayer().getItemInHand().getType().equals(Material.BLAZE_ROD)) {
			openTeleportMenu(event.getPlayer());
		}
	}
	
	@EventHandler
	public void playerInteract(PlayerDropItemEvent event) {
		if (event.getItemDrop().getItemStack().getItemMeta().getDisplayName().contains(ChatColor.GREEN + "")) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void inventoryInteract(InventoryClickEvent event) {
		try{
			if (event.getCurrentItem().getItemMeta().getDisplayName().contains(ChatColor.GREEN + "")) {
				if(event.getCurrentItem().getItemMeta().getDisplayName().contains(ChatColor.GREEN + "Spawn"))
					Main.pluginInstance.getServer().dispatchCommand(event.getWhoClicked(), "spawn");
				
				if(event.getCurrentItem().getItemMeta().getDisplayName().contains(ChatColor.GREEN + "Home"))
					Main.pluginInstance.getServer().dispatchCommand(event.getWhoClicked(), "home");
				
				if(event.getCurrentItem().getItemMeta().getDisplayName().contains(ChatColor.GREEN + "Wilderness"))
					Main.pluginInstance.getServer().dispatchCommand(event.getWhoClicked(), "rspawn wilderness");
				event.setCancelled(true);
			}
		}catch(NullPointerException e){
		}
	}

	@EventHandler
	public void inventoryInteractDrag(InventoryDragEvent event) {
		for (ItemStack item : event.getNewItems().values()) {
			try{
				if (item.getItemMeta().getDisplayName().contains(ChatColor.GREEN + ""))
					event.setCancelled(true);
			}catch(NullPointerException e){
				
			}
		}
	}

	private void openTeleportMenu(Player player) {
		Inventory teleportInventory = Bukkit.createInventory(null, 9, ChatColor.DARK_PURPLE + "My Spells");

		ItemStack beacon = new ItemStack(Material.BEACON);
		beacon.setItemMeta(AddWandMetaData.addBeaconMeta(beacon.getItemMeta()));
		teleportInventory.addItem(beacon);

		ItemStack sapling = new ItemStack(Material.SAPLING);
		sapling.setItemMeta(AddWandMetaData.addOakSaplingMeta(sapling.getItemMeta()));
		teleportInventory.addItem(sapling);

		ItemStack bed = new ItemStack(Material.BED);
		bed.setItemMeta(AddWandMetaData.addBedMeta(bed.getItemMeta()));
		teleportInventory.addItem(bed);

		player.openInventory(teleportInventory);

	}
}
