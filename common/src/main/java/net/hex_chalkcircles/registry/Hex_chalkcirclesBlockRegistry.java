package net.hex_chalkcircles.registry;

import static net.hex_chalkcircles.Hex_chalkcircles.id;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.hex_chalkcircles.Hex_chalkcircles;
import net.hex_chalkcircles.blocks.BlockDustRune;
import net.hex_chalkcircles.item.*;
import net.minecraft.core.Registry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;


public class Hex_chalkcirclesBlockRegistry {
    // Register items through this
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Hex_chalkcircles.MOD_ID, Registry.BLOCK_REGISTRY);
    public static final DeferredRegister<BlockEntityType<?>> BLOCKENTITIES = DeferredRegister.create(Hex_chalkcircles.MOD_ID, Registry.BLOCK_ENTITY_TYPE_REGISTRY);

    private static final Item.Properties CHALKCIRCLES_64STACK = new Item.Properties().stacksTo(64);
    private static final Item.Properties CHALKCIRCLES_16STACK = new Item.Properties().stacksTo(16);
    private static final Item.Properties CHALKCIRCLES_UNSTACKABLE = new Item.Properties().stacksTo(1);


    public static void init() {
        BLOCKS.register();
        BLOCKENTITIES.register();
    }

    // A new creative tab. Notice how it is one of the few things that are not deferred

    // During the loading phase, refrain from accessing suppliers' items (e.g. EXAMPLE_ITEM.get()), they will not be available
    public static final RegistrySupplier<BlockDustRune> CHALK_RUNE = BLOCKS.register("chalk_square_block", () -> new BlockDustRune();
}
