package net.hex_chalkcircles.item;

import at.petrak.hexcasting.common.items.ItemStaff;
import at.petrak.hexcasting.common.items.magic.ItemMediaHolder;
import at.petrak.hexcasting.common.items.magic.ItemPackagedHex;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class ItemChalkStick extends ItemMediaHolder {

	public ItemChalkStick(Properties pProperties) {
		super(pProperties);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canProvideMedia(ItemStack stack) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canRecharge(ItemStack stack) {
		// TODO Auto-generated method stub
		return false;
	}


	

}
