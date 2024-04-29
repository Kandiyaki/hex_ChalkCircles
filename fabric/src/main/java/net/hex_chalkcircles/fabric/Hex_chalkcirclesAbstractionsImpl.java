package net.hex_chalkcircles.fabric;

import net.fabricmc.loader.api.FabricLoader;
import net.hex_chalkcircles.Hex_chalkcirclesAbstractions;

import java.nio.file.Path;

public class Hex_chalkcirclesAbstractionsImpl {
    /**
     * This is the actual implementation of {@link Hex_chalkcirclesAbstractions#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
	
    public static void initPlatformSpecific() {
        Hex_chalkcirclesConfigFabric.init();
    }
}
