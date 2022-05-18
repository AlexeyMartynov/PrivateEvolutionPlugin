package io.github.alexeymartynov.private_evolution.privates;

import io.github.alexeymartynov.private_evolution.main.PrivateEvolution;
import org.bukkit.configuration.file.FileConfiguration;

public enum PrivateType {

    FRACTION,
    EVOLUTION;

    static
    {
        FileConfiguration config = PrivateEvolution.getInstance().getLocalizationConfig();
        for(PrivateType type : PrivateType.values())
            type.setName(config.getString("names.private_type_" + type.toString().toLowerCase()));
    }

    private String name;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
