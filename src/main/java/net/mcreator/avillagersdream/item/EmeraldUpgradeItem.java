package net.mcreator.avillagersdream.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class EmeraldUpgradeItem extends Item {
	public EmeraldUpgradeItem() {
		super(new Item.Properties());
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.a_villagers_dream.emerald_upgrade.description_0"));
		list.add(Component.translatable("item.a_villagers_dream.emerald_upgrade.description_1"));
		list.add(Component.translatable("item.a_villagers_dream.emerald_upgrade.description_2"));
		list.add(Component.translatable("item.a_villagers_dream.emerald_upgrade.description_3"));
		list.add(Component.translatable("item.a_villagers_dream.emerald_upgrade.description_4"));
		list.add(Component.translatable("item.a_villagers_dream.emerald_upgrade.description_5"));
	}
}