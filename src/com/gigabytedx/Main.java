package com.gigabytedx;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.gigabytedx.commands.GetWand;
import com.gigabytedx.interact.Interact;
import com.gigabytedx.inventory.Spawn;

public class Main extends JavaPlugin {
	public static Main pluginInstance;
	
	public void onEnable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		registerCommands();
		registerEvents();
		registerConfig();
		logger.info(pdfFile.getName() + " has been enabled (V." + pdfFile.getVersion() + ")");
		pluginInstance = this;
	}

	public void onDisable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();

		logger.info(pdfFile.getName() + " has been disabled (V." + pdfFile.getVersion() + ")");
	}

	private void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new Interact(), this);
		pm.registerEvents(new Spawn(), this);
	}

	private void registerCommands() {
		getCommand("getwand").setExecutor(new GetWand());
	}
	
	private void registerConfig(){
		saveDefaultConfig();
	}
}