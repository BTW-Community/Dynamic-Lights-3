package btw.community.dynamiclights;

import api.AddonHandler;
import api.BTWAddon;
import btw.block.BTWBlocks;
import net.fabricmc.api.ModInitializer;
import net.minecraft.src.Block;

import java.util.ArrayList;
import java.util.List;

public class DynamicLightsAddon extends BTWAddon implements ModInitializer {
    private static DynamicLightsAddon instance;

    public static Block lightSource;
    public static final int LIGHT_SOURCE_ID = 2042;
    public static List<Integer> lightEmittingItems = new ArrayList<>();

    public DynamicLightsAddon() {
        super();
    }

    @Override
    public void initialize() {
        AddonHandler.logMessage(this.getName() + " Version " + this.getVersionString() + " Initializing...");
        lightSource = new DynamicLightSourceBlock(LIGHT_SOURCE_ID - 256);

        lightEmittingItems.add(BTWBlocks.finiteBurningTorch.blockID);
        lightEmittingItems.add(BTWBlocks.infiniteBurningTorch.blockID);
        lightEmittingItems.add(BTWBlocks.jackOLantern.blockID);
        lightEmittingItems.add(Block.glowStone.blockID);
    }

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

    }
}