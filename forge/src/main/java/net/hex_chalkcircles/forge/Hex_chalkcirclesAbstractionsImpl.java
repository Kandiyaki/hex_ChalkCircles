package net.hex_chalkcircles.forge;

import net.hex_chalkcircles.Hex_chalkcirclesAbstractions;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class Hex_chalkcirclesAbstractionsImpl {
    /**
     * This is the actual implementation of {@link Hex_chalkcirclesAbstractions#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
	
    public static void initPlatformSpecific() {
        Hex_chalkcirclesConfigForge.init();
    }
}
