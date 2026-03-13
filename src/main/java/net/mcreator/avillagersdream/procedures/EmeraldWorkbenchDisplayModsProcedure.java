package net.mcreator.avillagersdream.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import net.mcreator.avillagersdream.init.AVillagersDreamModMenus;

public class EmeraldWorkbenchDisplayModsProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		ItemStack item = ItemStack.EMPTY;
		ItemStack mod_item = ItemStack.EMPTY;
		item = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(1).getItem() : ItemStack.EMPTY).copy();
		mod_item = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu1 ? _menu1.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
		if (item.getItem() == Items.EMERALD) {
			if ((mod_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality")).equals("Bulky")) {
				return "Modifiers" + "\n" + "\u00A79+"
						+ (Math.round((((entity instanceof Player _entity4 && _entity4.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu4) ? _menu4.getMenuState(2, "Investment", 0.0) : 0.0) / 12) * 100) / 100d) + " Armor" + "\n"
						+ "\u00A7c-" + (Math.round((((entity instanceof Player _entity5 && _entity5.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu5) ? _menu5.getMenuState(2, "Investment", 0.0) : 0.0) / 100) * 100) / 100d)
						+ " Movement Speed";
			}
			if ((mod_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality")).equals("Sturdy")) {
				return "Modifiers" + "\n" + "\u00A79+"
						+ (Math.round((((entity instanceof Player _entity7 && _entity7.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu7) ? _menu7.getMenuState(2, "Investment", 0.0) : 0.0) / 20) * 100) / 100d) + " Armor Toughness"
						+ "\n" + "\u00A79+" + (Math.round((((entity instanceof Player _entity8 && _entity8.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu8) ? _menu8.getMenuState(2, "Investment", 0.0) : 0.0) / 40) * 100) / 100d)
						+ " Knockback Resistance";
			}
			if ((mod_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality")).equals("Greedy")) {
				return "Modifiers" + "\n" + "\u00A79+"
						+ (Math.round((((entity instanceof Player _entity10 && _entity10.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu10) ? _menu10.getMenuState(2, "Investment", 0.0) : 0.0) / 32) * 100) / 100d) + " Luck";
			}
			if ((mod_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality")).equals("Prosperous")) {
				return "Modifiers" + "\n" + "\u00A79+"
						+ (Math.round((((entity instanceof Player _entity12 && _entity12.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu12) ? _menu12.getMenuState(2, "Investment", 0.0) : 0.0) / 8) * 100) / 100d) + " Max Health";
			}
			if ((mod_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality")).equals("Unlucky")) {
				return "Modifiers" + "\n" + "\u00A7c-2 Luck" + "\n" + "\u00A7c-"
						+ (Math.round(((entity instanceof Player _entity14 && _entity14.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu14) ? _menu14.getMenuState(2, "Investment", 0.0) : 0.0) * 2 * 100) / 100d) + " Durability";
			}
		}
		return "Modifiers" + "\n" + "\u00A77None";
	}
}