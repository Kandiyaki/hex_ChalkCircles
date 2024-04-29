package net.hex_chalkcircles.forge;

import dev.architectury.platform.forge.EventBuses;
import net.hex_chalkcircles.Hex_chalkcircles;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * This is your loading entrypoint on forge, in case you need to initialize
 * something platform-specific.
 */
@Mod(Hex_chalkcircles.MOD_ID)
public class Hex_chalkcirclesForge {
    public Hex_chalkcirclesForge() {
        // Submit our event bus to let architectury register our content on the right time
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(Hex_chalkcircles.MOD_ID, bus);
        bus.addListener(Hex_chalkcirclesClientForge::init);
        Hex_chalkcircles.init();
    }
}
