package net.hex_chalkcircles;

import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.architectury.platform.Platform;

import java.nio.file.Path;

public class Hex_chalkcirclesAbstractions {
    /**
     * This explanation is mostly from Architectury's template project.
     * One thing I would like to add for those familiar with Hex Casting's layout:
     * this is a somewhat simpler and more intuitive (imo) way to accomplish what they accomplish with Xplat abstractions.
     * <p>
     * We can use {@link Platform#getConfigFolder()} but this is just an example of {@link ExpectPlatform}.
     * <p>
     * This must be a <b>public static</b> method. The platform-implemented solution must be placed under a
     * platform sub-package, with its class suffixed with {@code Impl}.
     * <p>
     * Example:
     * <p>
     * Expect: net.hex_chalkcircles.Hex_chalkcirclesAbstractions#getConfigDirectory()
     * <p>
     * Actual Fabric: net.hex_chalkcircles.fabric.Hex_chalkcirclesAbstractionsImpl#getConfigDirectory()
     * <p>
     * Actual Forge: net.hex_chalkcircles.forge.Hex_chalkcirclesAbstractionsImpl#getConfigDirectory()
     * <p>
     * <a href="https://plugins.jetbrains.com/plugin/16210-architectury">You should also get the IntelliJ plugin to help with @ExpectPlatform.</a>
     */
    @ExpectPlatform
    public static Path getConfigDirectory() {
        // Just throw an error, the content should get replaced at runtime.
        throw new AssertionError();
    }
	
    @ExpectPlatform
    public static void initPlatformSpecific() {
        throw new AssertionError();
    }
}