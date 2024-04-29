package net.hex_chalkcircles.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.hex_chalkcircles.Hex_chalkcirclesClient;

/**
 * Fabric client loading entrypoint.
 */
public class Hex_chalkcirclesClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Hex_chalkcirclesClient.init();
    }
}
