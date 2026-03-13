package net.mcreator.avillagersdream.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import net.mcreator.avillagersdream.init.AVillagersDreamModMenus;
import net.mcreator.avillagersdream.init.AVillagersDreamModItems;

public class EmeraldWorkbenchQualityDisplayProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.EMERALD) {
				return "Quality: \u00A7a" + ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu4 ? _menu4.getSlots().get(0).getItem() : ItemStack.EMPTY)
						.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality"));
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == AVillagersDreamModItems.RUBY
					.get()) {
				return "Quality: \u00A7c" + ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu8 ? _menu8.getSlots().get(0).getItem() : ItemStack.EMPTY)
						.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("rubyQuality"));
			}
		}
		return "Quality: None";
	}
}