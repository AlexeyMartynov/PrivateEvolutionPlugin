package io.github.alexeymartynov.private_evolution.privates;

import io.github.alexeymartynov.private_evolution.main.PrivateEvolution;
import io.github.alexeymartynov.private_evolution.util.Name;
import org.bukkit.configuration.file.FileConfiguration;

public enum PrivateType {

    FRACTION(Name.ICON_PRIVATE_FRACTION, 50),
    EVOLUTION(Name.ICON_PRIVATE_EVOLUTION, PrivateUpgradeStage.CITY.getChunkSize());

    private Name name;
    private int maxChunkSize;

    private PrivateType(Name name, int maxChunkSize)
    {
        this.name = name;
        this.maxChunkSize = maxChunkSize;
    }

    public String getName() { return name.get(); }

    public int getMaxChunkSize() { return maxChunkSize; }
}
