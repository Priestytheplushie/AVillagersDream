package net.mcreator.avillagersdream.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import net.mcreator.avillagersdream.init.AVillagersDreamModMenus;
import net.mcreator.avillagersdream.init.AVillagersDreamModItems;

public class EmeraldWorkbenchSlot0Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double randomRoll = 0;
		ItemStack toolStack = ItemStack.EMPTY;
		ItemStack previewStack = ItemStack.EMPTY;
		toolStack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
		if (!(toolStack.getItem() == Blocks.AIR.asItem())) {
			if ((toolStack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality")).equals("")
					|| (toolStack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality")).equals("none")) {
				randomRoll = Mth.nextInt(RandomSource.create(), 1, 100);
				if (randomRoll < 15) {
					{
						final String _tagName = "emeraldQuality";
						final String _tagValue = "Unlucky";
						CustomData.update(DataComponents.CUSTOM_DATA, toolStack, tag -> tag.putString(_tagName, _tagValue));
					}
					{
						final String _tagName = "rubyQuality";
						final String _tagValue = "Brittle";
						CustomData.update(DataComponents.CUSTOM_DATA, toolStack, tag -> tag.putString(_tagName, _tagValue));
					}
				} else if (randomRoll < 40) {
					{
						final String _tagName = "emeraldQuality";
						final String _tagValue = "Bulky";
						CustomData.update(DataComponents.CUSTOM_DATA, toolStack, tag -> tag.putString(_tagName, _tagValue));
					}
					{
						final String _tagName = "rubyQuality";
						final String _tagValue = "Heavy";
						CustomData.update(DataComponents.CUSTOM_DATA, toolStack, tag -> tag.putString(_tagName, _tagValue));
					}
				} else if (randomRoll < 70) {
					{
						final String _tagName = "emeraldQuality";
						final String _tagValue = "Sturdy";
						CustomData.update(DataComponents.CUSTOM_DATA, toolStack, tag -> tag.putString(_tagName, _tagValue));
					}
					{
						final String _tagName = "rubyQuality";
						final String _tagValue = "Sharp";
						CustomData.update(DataComponents.CUSTOM_DATA, toolStack, tag -> tag.putString(_tagName, _tagValue));
					}
				} else {
					{
						final String _tagName = "emeraldQuality";
						final String _tagValue = "Prosperous";
						CustomData.update(DataComponents.CUSTOM_DATA, toolStack, tag -> tag.putString(_tagName, _tagValue));
					}
					{
						final String _tagName = "rubyQuality";
						final String _tagValue = "Hasty";
						CustomData.update(DataComponents.CUSTOM_DATA, toolStack, tag -> tag.putString(_tagName, _tagValue));
					}
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu) {
					ItemStack _setstack13 = toolStack.copy();
					_setstack13.setCount(1);
					_menu.getSlots().get(0).set(_setstack13);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu) {
			_menu.getSlots().get(2).set(ItemStack.EMPTY);
			_player.containerMenu.broadcastChanges();
		}
		if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu15 ? _menu15.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())
				&& !((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu17 ? _menu17.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
			previewStack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu19 ? _menu19.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
			if (previewStack.is(ItemTags.create(ResourceLocation.parse("minecraft:tools"))) || previewStack.is(ItemTags.create(ResourceLocation.parse("minecraft:swords")))
					|| previewStack.is(ItemTags.create(ResourceLocation.parse("minecraft:armor")))) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu23 ? _menu23.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.EMERALD) {
					previewStack.set(DataComponents.CUSTOM_NAME, Component.literal(("\u00A7a" + previewStack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality") + "\u00A7f "
							+ (previewStack.getDisplayName().getString()).substring(1, (previewStack.getDisplayName().getString()).length() - 1))));
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu29 ? _menu29.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == AVillagersDreamModItems.RUBY
						.get()) {
					previewStack.set(DataComponents.CUSTOM_NAME, Component.literal(("\u00A7c" + previewStack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("rubyQuality") + "\u00A7f"
							+ (previewStack.getDisplayName().getString()).substring(1, (previewStack.getDisplayName().getString()).length() - 1))));
				}
				{
					final String _tagName = "isPreview";
					final boolean _tagValue = true;
					CustomData.update(DataComponents.CUSTOM_DATA, previewStack, tag -> tag.putBoolean(_tagName, _tagValue));
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu) {
					ItemStack _setstack36 = previewStack.copy();
					_setstack36.setCount(1);
					_menu.getSlots().get(2).set(_setstack36);
					_player.containerMenu.broadcastChanges();
				}
			} else {
				if (entity instanceof Player _player && _player.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(2).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
	}
}