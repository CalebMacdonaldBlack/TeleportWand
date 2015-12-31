package com.gigabytedx.inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import com.gigabytedx.Main;

public class Spawn implements Listener{

	@EventHandler
	public void onSpawn(PlayerRespawnEvent event){
		Main.pluginInstance.getServer().dispatchCommand(event.getPlayer(), "getwand");
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		Main.pluginInstance.getServer().dispatchCommand(event.getPlayer(), "getwand");
	}
}
