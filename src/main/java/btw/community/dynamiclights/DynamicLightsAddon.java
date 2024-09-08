package btw.community.dynamiclights;

import btw.AddonHandler;
import btw.BTWAddon;
import net.fabricmc.api.ModInitializer;
import net.minecraft.src.Block;

public class DynamicLightsAddon extends BTWAddon implements ModInitializer {
    private static DynamicLightsAddon instance;

    public static Block lightSource;
    public static final int LIGHT_SOURCE_ID = 2042;

    public DynamicLightsAddon() {
        super();
    }

    @Override
    public void initialize() {
        AddonHandler.logMessage(this.getName() + " Version " + this.getVersionString() + " Initializing...");
        lightSource = new DynamicLightSourceBlock(LIGHT_SOURCE_ID - 256);
    }

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

    }
}