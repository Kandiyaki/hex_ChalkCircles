package net.hex_chalkcircles.registry;

import static net.hex_chalkcircles.Hex_chalkcircles.id;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.hex_chalkcircles.Hex_chalkcircles;
import net.hex_chalkcircles.blocks.BlockDustRune;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.AbstractGlassBlock;
import at.petrak.hexcasting.api.block.circle.*;


public class Hex_chalkcirclesBlockRegistry {
    // Register items through this
	
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Hex_chalkcircles.MOD_ID, Registry.BLOCK_REGISTRY);
    public static final DeferredRegister<BlockEntityType<?>> BLOCKENTITIES = DeferredRegister.create(Hex_chalkcircles.MOD_ID, Registry.BLOCK_ENTITY_TYPE_REGISTRY);



    public static void init() {
        BLOCKS.register();
        //BLOCKENTITIES.register();
    }

    // A new creative tab. Notice how it is one of the few things that are not deferred

    // During the loading phase, refrain from accessing suppliers' items (e.g. EXAMPLE_ITEM.get()), they will not be available
    public static final RegistrySupplier<Block> CHALK_RUNE = BLOCKS.register("chalk_square_block", () -> new BlockDustRune(BlockBehaviour.Properties.of(Material.AMETHYST).noOcclusion()));

}
