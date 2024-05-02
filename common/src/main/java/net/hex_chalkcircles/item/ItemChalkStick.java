package net.hex_chalkcircles.item;

import at.petrak.hexcasting.common.items.ItemStaff;

import at.petrak.hexcasting.common.lib.HexSounds;
import at.petrak.hexcasting.common.network.MsgOpenSpellGuiAck;
import at.petrak.hexcasting.xplat.IXplatAbstractions;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import net.hex_chalkcircles.registry.Hex_chalkcirclesBlockRegistry;


public class ItemChalkStick extends AbstractChalkBlockItem {
	
	private static final Block BLOCK_DUST_RUNE= Hex_chalkcirclesBlockRegistry.CHALK_RUNE.get();


	public ItemChalkStick(Properties pProperties) {
		super(BLOCK_DUST_RUNE, pProperties);
	}

	@Override
	public InteractionResult place(BlockPlaceContext blockplacecontext) {
		//TODO call the casting grid and wait until an iota is passed
		return super.place(blockplacecontext);
		
		
	}
	
	
	@Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if (player.isShiftKeyDown()) {
            if (world.isClientSide()) {
                player.playSound(HexSounds.FAIL_PATTERN, 1f, 1f);
            } else if (player instanceof ServerPlayer serverPlayer) {
                IXplatAbstractions.INSTANCE.clearCastingData(serverPlayer);
            }
        }

        if (!world.isClientSide() && player instanceof ServerPlayer serverPlayer) {
            var harness = IXplatAbstractions.INSTANCE.getHarness(serverPlayer, hand);
            var patterns = IXplatAbstractions.INSTANCE.getPatterns(serverPlayer);
            var descs = harness.generateDescs();

            IXplatAbstractions.INSTANCE.sendPacketToPlayer(serverPlayer,
                new MsgOpenSpellGuiAck(hand, patterns, descs.getFirst(), descs.getSecond(), descs.getThird(),
                    harness.getParenCount()));
        }

        player.awardStat(Stats.ITEM_USED.get(this));
//        player.gameEvent(GameEvent.ITEM_INTERACT_START);

        return InteractionResultHolder.success(player.getItemInHand(hand));
    }

	

}
