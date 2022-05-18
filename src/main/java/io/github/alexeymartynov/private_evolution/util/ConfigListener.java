package com.akamarucraft.util;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;

public abstract class ConfigListener {

	protected File folder;
	public File file;
	public FileConfiguration config;
	
/*	protected ConfigListener(File folder, File file) 
	{
		this.folder = folder;
		if(!folder.exists())
			folder.mkdir();
		
		this.file = file;
		if(!file.exists()) 
		{		
			try { file.createNewFile(); }
			catch(Exception exception) { exception.printStackTrace(); }
			
			config = YamlConfiguration.loadConfiguration(file);	
			save();
			create();
		}
		else config = YamlConfiguration.loadConfiguration(file);	
		
		save();
	} */
	
	public abstract void create();
	
	public void save() 
	{
		try { config.save(file); }
		catch(Exception exception) {}
	}
	
	public void delete() 
	{
		if(file.exists())
			file.delete();
	}
}
