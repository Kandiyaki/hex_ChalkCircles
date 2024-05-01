package net.hex_chalkcircles;

import net.hex_chalkcircles.registry.Hex_chalkcirclesIotaTypeRegistry;
import net.hex_chalkcircles.registry.Hex_chalkcirclesItemRegistry;
import net.hex_chalkcircles.registry.Hex_chalkcirclesPatternRegistry;
import net.hex_chalkcircles.registry.Hex_chalkcirclesBlockRegistry;
import net.hex_chalkcircles.networking.Hex_chalkcirclesNetworking;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This is effectively the loading entrypoint for most of your code, at least
 * if you are using Architectury as intended.
 */
public class Hex_chalkcircles {
    public static final String MOD_ID = "hex_chalkcircles";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);


    public static void init() {
        LOGGER.info("Hex Circles says hello!");

        
        Hex_chalkcirclesAbstractions.initPlatformSpecific();
        Hex_chalkcirclesBlockRegistry.init();
        Hex_chalkcirclesItemRegistry.init();
        Hex_chalkcirclesIotaTypeRegistry.init();
        Hex_chalkcirclesPatternRegistry.init();
		Hex_chalkcirclesNetworking.init();

        LOGGER.info(Hex_chalkcirclesAbstractions.getConfigDirectory().toAbsolutePath().normalize().toString());
    }

    /**
     * Shortcut for identifiers specific to this mod.
     */
    public static ResourceLocation id(String string) {
        return new ResourceLocation(MOD_ID, string);
    }
}
