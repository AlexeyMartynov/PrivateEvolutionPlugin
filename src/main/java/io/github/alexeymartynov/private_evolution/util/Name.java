package io.github.alexeymartynov.private_evolution.util;

import io.github.alexeymartynov.private_evolution.main.PrivateEvolution;
import org.bukkit.configuration.file.FileConfiguration;

public enum Name {

    TITLE_GUI_PRIVATE_MENU,
    TITLE_GUI_PICK_PRIVATE_TYPE,
    ICON_PRIVATE_FRACTION,
    ICON_PRIVATE_EVOLUTION,
    ICON_INFORMATION,
    ICON_UPGRADE;

    private String name;

    static
    {
        FileConfiguration config = PrivateEvolution.getInstance().getLocalizationConfig();
        for(Name name : Name.values())
            name.setName(config.getString("names." + name.toString().toLowerCase()));
    }

    public void setName(String name) { this.name = name; }

    public String getName() { return name; }
}
