package btw.community.dynamiclights;

import btw.AddonHandler;
import btw.BTWAddon;
import net.fabricmc.api.ModInitializer;

public class DynamicLightsAddon extends BTWAddon implements ModInitializer {
    private static DynamicLightsAddon instance;

    public DynamicLightsAddon() {
        super();
    }

    @Override
    public void initialize() {
        AddonHandler.logMessage(this.getName() + " Version " + this.getVersionString() + " Initializing...");
    }

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

    }
}