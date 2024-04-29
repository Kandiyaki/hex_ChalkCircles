package net.hex_chalkcircles.registry;

import static net.hex_chalkcircles.Hex_chalkcircles.id;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.hex_chalkcircles.Hex_chalkcircles;
import net.hex_chalkcircles.item.*;
import net.minecraft.core.Registry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class Hex_chalkcirclesItemRegistry {
    // Register items through this
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Hex_chalkcircles.MOD_ID, Registry.ITEM_REGISTRY);
    private static final Item.Properties CHALKCIRCLES_UNSTACKABLE = new Item.Properties().stacksTo(1);


    public static void init() {
        ITEMS.register();
    }

    // A new creative tab. Notice how it is one of the few things that are not deferred
    public static final CreativeModeTab CHALKCIRCLES_GROUP = CreativeTabRegistry.create(id("chalk_circles"), () -> new ItemStack(Hex_chalkcirclesItemRegistry.CHALKSTICK_ITEM.get()));

    // During the loading phase, refrain from accessing suppliers' items (e.g. EXAMPLE_ITEM.get()), they will not be available
    public static final RegistrySupplier<Item> CHALKSTICK_ITEM = ITEMS.register("amethyst_chalk", () -> new ItemChalkStick(CHALKCIRCLES_UNSTACKABLE));


}
