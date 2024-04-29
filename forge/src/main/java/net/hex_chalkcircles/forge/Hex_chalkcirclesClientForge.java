package net.hex_chalkcircles.forge;

import net.hex_chalkcircles.Hex_chalkcirclesClient;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

/**
 * Forge client loading entrypoint.
 */
public class Hex_chalkcirclesClientForge {
    public static void init(FMLClientSetupEvent event) {
        Hex_chalkcirclesClient.init();
    }
}
