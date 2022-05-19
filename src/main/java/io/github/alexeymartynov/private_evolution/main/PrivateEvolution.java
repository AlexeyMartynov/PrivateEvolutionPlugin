package io.github.alexeymartynov.private_evolution.main;

import io.github.alexeymartynov.private_evolution.privates.PrivateHandler;
import io.github.alexeymartynov.private_evolution.privates.PrivateManager;
import io.github.alexeymartynov.private_evolution.util.Icon;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class PrivateEvolution extends JavaPlugin {

    private static PrivateEvolution instance;

    private PrivateManager privateManager;
    private PrivateHandler privateHandler;

    private File localizationFile = new File(getDataFolder() + File.separator + "localization.yml"),
            privatesFile = new File(getDataFolder() + File.separator + "privates.yml");

    private FileConfiguration localizationConfig, privatesConfig;

    @Override
    public void onEnable()
    {
        instance = this;

        initializeConfigs();

        privateManager = new PrivateManager();
        privateHandler = new PrivateHandler();
        Bukkit.getPluginManager().registerEvents(privateHandler, getInstance());

        // зарегать команду
    }

    @Override
    public void onDisable() {}

    public static PrivateEvolution getInstance() { return instance; }

    private void initializeConfigs()
    {
        localizationFile.mkdir();
        privatesFile.mkdir();

        if(!localizationFile.exists())
            saveResource("localization.yml", false);

        if(!privatesFile.exists())
            saveResource("localization.yml", false);

        localizationConfig = YamlConfiguration.loadConfiguration(localizationFile);
        privatesConfig = YamlConfiguration.loadConfiguration(localizationFile);
    }

    private void saveConfig(FileConfiguration config, File file)
    {
        try { config.save(file); }
        catch (Exception exception) {}
    }

    public PrivateManager getPrivateManager() { return privateManager; }

    public void saveLocalizationConfig() { saveConfig(localizationConfig, localizationFile); }

    public FileConfiguration getLocalizationConfig() { return localizationConfig; }

    public void savePrivatesConfig() { saveConfig(privatesConfig, privatesFile); }

    public FileConfiguration getPrivatesConfig() { return privatesConfig; }
}
