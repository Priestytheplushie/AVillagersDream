package net.mcreator.avillagersdream.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
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
		String originalName = "";
		ItemStack toolStack = ItemStack.EMPTY;
		ItemStack previewStack = ItemStack.EMPTY;
		toolStack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
		if (toolStack.is(ItemTags.create(ResourceLocation.parse("minecraft:swords"))) || toolStack.is(ItemTags.create(ResourceLocation.parse("minecraft:axes")))
				|| toolStack.is(ItemTags.create(ResourceLocation.parse("a_villagers_dream:eligible_equipment")))) {
			if ((toolStack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality")).equals("")
					|| (toolStack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality")).equals("none")) {
				randomRoll = randomRoll = entity.level().random.nextInt(1, 320);;
				if (randomRoll < 15) {
					{
						final String _tagName = "emeraldQuality";
						final String _tagValue = "Long";
						CustomData.update(DataComponents.CUSTOM_DATA, toolStack, tag -> tag.putString(_tagName, _tagValue));
					}
				} else if (randomRoll < 40) {
					{
						final String _tagName = "emeraldQuality";
						final String _tagValue = "Bulky";
						CustomData.update(DataComponents.CUSTOM_DATA, toolStack, tag -> tag.putString(_tagName, _tagValue));
					}
				} else if (randomRoll < 70) {
					{
						final String _tagName = "emeraldQuality";
						final String _tagValue = "Sturdy";
						CustomData.update(DataComponents.CUSTOM_DATA, toolStack, tag -> tag.putString(_tagName, _tagValue));
					}
				} else if (randomRoll < 100) {
					{
						final String _tagName = "emeraldQuality";
						final String _tagValue = "Hasty";
						CustomData.update(DataComponents.CUSTOM_DATA, toolStack, tag -> tag.putString(_tagName, _tagValue));
					}
				} else if (randomRoll < 130) {
					{
						final String _tagName = "emeraldQuality";
						final String _tagValue = "Sharp";
						CustomData.update(DataComponents.CUSTOM_DATA, toolStack, tag -> tag.putString(_tagName, _tagValue));
					}
				} else if (randomRoll < 170) {
					{
						final String _tagName = "emeraldQuality";
						final String _tagValue = "Heavy";
						CustomData.update(DataComponents.CUSTOM_DATA, toolStack, tag -> tag.putString(_tagName, _tagValue));
					}
				} else if (randomRoll < 200) {
					{
						final String _tagName = "emeraldQuality";
						final String _tagValue = "Light";
						CustomData.update(DataComponents.CUSTOM_DATA, toolStack, tag -> tag.putString(_tagName, _tagValue));
					}
				} else if (randomRoll < 225) {
					{
						final String _tagName = "emeraldQuality";
						final String _tagValue = "Vibrant";
						CustomData.update(DataComponents.CUSTOM_DATA, toolStack, tag -> tag.putString(_tagName, _tagValue));
					}
				} else if (randomRoll < 245) {
					{
						final String _tagName = "emeraldQuality";
						final String _tagValue = "Legendary";
						CustomData.update(DataComponents.CUSTOM_DATA, toolStack, tag -> tag.putString(_tagName, _tagValue));
					}
				} else if (randomRoll < 275) {
					{
						final String _tagName = "emeraldQuality";
						final String _tagValue = "Colossal";
						CustomData.update(DataComponents.CUSTOM_DATA, toolStack, tag -> tag.putString(_tagName, _tagValue));
					}
				} else {
					{
						final String _tagName = "emeraldQuality";
						final String _tagValue = "Prosperous";
						CustomData.update(DataComponents.CUSTOM_DATA, toolStack, tag -> tag.putString(_tagName, _tagValue));
					}
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu) {
					ItemStack _setstack17 = toolStack.copy();
					_setstack17.setCount(1);
					_menu.getSlots().get(0).set(_setstack17);
					_player.containerMenu.broadcastChanges();
				}
			}
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu) {
			_menu.getSlots().get(2).set(ItemStack.EMPTY);
			_player.containerMenu.broadcastChanges();
		}
		if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu19 ? _menu19.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())
				&& ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu21 ? _menu21.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.EMERALD
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu23 ? _menu23.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == AVillagersDreamModItems.RUBY
								.get())) {
			previewStack = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu25 ? _menu25.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
			if (previewStack.is(ItemTags.create(ResourceLocation.parse("minecraft:swords"))) || previewStack.is(ItemTags.create(ResourceLocation.parse("a_villagers_dream:eligible_equipment")))) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu28 ? _menu28.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == Items.EMERALD) {
					previewStack.set(DataComponents.CUSTOM_NAME, Component.literal(("\u00A7a" + previewStack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality") + "\u00A7f "
							+ (previewStack.getDisplayName().getString()).substring(1, (previewStack.getDisplayName().getString()).length() - 1))));
					if ((previewStack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality")).equals("Bulky")) {
						{
							final String _tagName = "modifier1";
							final double _tagValue = (Math
									.round((((entity instanceof Player _entity35 && _entity35.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu35) ? _menu35.getMenuState(2, "Investment", 0.0) : 0.0) / 12) * 100) / 100d);
							CustomData.update(DataComponents.CUSTOM_DATA, previewStack, tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "modifier2";
							final double _tagValue = (Math
									.round((((entity instanceof Player _entity37 && _entity37.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu37) ? _menu37.getMenuState(2, "Investment", 0.0) : 0.0) / 64) * 100) / 100d);
							CustomData.update(DataComponents.CUSTOM_DATA, previewStack, tag -> tag.putDouble(_tagName, _tagValue));
						}
					}
					if ((previewStack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality")).equals("Sturdy")) {
						{
							final String _tagName = "modifier1";
							final double _tagValue = (Math
									.round((((entity instanceof Player _entity40 && _entity40.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu40) ? _menu40.getMenuState(2, "Investment", 0.0) : 0.0) / 20) * 100) / 100d);
							CustomData.update(DataComponents.CUSTOM_DATA, previewStack, tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "modifier2";
							final double _tagValue = (Math
									.round((((entity instanceof Player _entity42 && _entity42.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu42) ? _menu42.getMenuState(2, "Investment", 0.0) : 0.0) / 80) * 100) / 100d);
							CustomData.update(DataComponents.CUSTOM_DATA, previewStack, tag -> tag.putDouble(_tagName, _tagValue));
						}
					}
					if ((previewStack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality")).equals("Greedy")) {
						{
							final String _tagName = "modifier1";
							final double _tagValue = (Math
									.round((((entity instanceof Player _entity45 && _entity45.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu45) ? _menu45.getMenuState(2, "Investment", 0.0) : 0.0) / 32) * 100) / 100d);
							CustomData.update(DataComponents.CUSTOM_DATA, previewStack, tag -> tag.putDouble(_tagName, _tagValue));
						}
					}
					if ((previewStack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality")).equals("Prosperous")) {
						{
							final String _tagName = "modifier1";
							final double _tagValue = (Math.round((((entity instanceof Player _entity48 && _entity48.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu48) ? _menu48.getMenuState(2, "Investment", 0.0) : 0.0) / 8) * 100)
									/ 100d);
							CustomData.update(DataComponents.CUSTOM_DATA, previewStack, tag -> tag.putDouble(_tagName, _tagValue));
						}
					}
					if ((previewStack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality")).equals("Long")) {
						{
							final String _tagName = "modifier1";
							final double _tagValue = (Math
									.round((((entity instanceof Player _entity51 && _entity51.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu51) ? _menu51.getMenuState(2, "Investment", 0.0) : 0.0) / 32) * 100) / 100d);
							CustomData.update(DataComponents.CUSTOM_DATA, previewStack, tag -> tag.putDouble(_tagName, _tagValue));
						}
					}
					if ((previewStack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality")).equals("Sharp")) {
						{
							final String _tagName = "modifier1";
							final double _tagValue = (Math
									.round((((entity instanceof Player _entity54 && _entity54.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu54) ? _menu54.getMenuState(2, "Investment", 0.0) : 0.0) / 24) * 100) / 100d);
							CustomData.update(DataComponents.CUSTOM_DATA, previewStack, tag -> tag.putDouble(_tagName, _tagValue));
						}
					}
					if ((previewStack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality")).equals("Hasty")) {
						{
							final String _tagName = "modifier1";
							final double _tagValue = (Math
									.round((((entity instanceof Player _entity57 && _entity57.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu57) ? _menu57.getMenuState(2, "Investment", 0.0) : 0.0) / 40) * 100) / 100d);
							CustomData.update(DataComponents.CUSTOM_DATA, previewStack, tag -> tag.putDouble(_tagName, _tagValue));
						}
					}
					if ((previewStack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality")).equals("Heavy")) {
						{
							final String _tagName = "modifier1";
							final double _tagValue = (Math
									.round((((entity instanceof Player _entity60 && _entity60.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu60) ? _menu60.getMenuState(2, "Investment", 0.0) : 0.0) / 20) * 100) / 100d);
							CustomData.update(DataComponents.CUSTOM_DATA, previewStack, tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "modifier2";
							final double _tagValue = (Math
									.round((((entity instanceof Player _entity62 && _entity62.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu62) ? _menu62.getMenuState(2, "Investment", 0.0) : 0.0) / 64) * 100) / 100d);
							CustomData.update(DataComponents.CUSTOM_DATA, previewStack, tag -> tag.putDouble(_tagName, _tagValue));
						}
					}
					if ((previewStack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality")).equals("Light")) {
						{
							final String _tagName = "modifier1";
							final double _tagValue = (Math
									.round((((entity instanceof Player _entity65 && _entity65.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu65) ? _menu65.getMenuState(2, "Investment", 0.0) : 0.0) / 100) * 100) / 100d);
							CustomData.update(DataComponents.CUSTOM_DATA, previewStack, tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "modifier2";
							final double _tagValue = (Math
									.round((((entity instanceof Player _entity67 && _entity67.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu67) ? _menu67.getMenuState(2, "Investment", 0.0) : 0.0) / 64) * 100) / 100d);
							CustomData.update(DataComponents.CUSTOM_DATA, previewStack, tag -> tag.putDouble(_tagName, _tagValue));
						}
					}
					if ((previewStack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality")).equals("Vibrant")) {
						{
							final String _tagName = "modifier1";
							final double _tagValue = (Math
									.round((((entity instanceof Player _entity70 && _entity70.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu70) ? _menu70.getMenuState(2, "Investment", 0.0) : 0.0) / 24) * 100) / 100d);
							CustomData.update(DataComponents.CUSTOM_DATA, previewStack, tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "modifier2";
							final double _tagValue = (Math
									.round((((entity instanceof Player _entity72 && _entity72.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu72) ? _menu72.getMenuState(2, "Investment", 0.0) : 0.0) / 16) * 100) / 100d);
							CustomData.update(DataComponents.CUSTOM_DATA, previewStack, tag -> tag.putDouble(_tagName, _tagValue));
						}
					}
					if ((previewStack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality")).equals("Legendary")) {
						{
							final String _tagName = "modifier1";
							final double _tagValue = (Math
									.round((((entity instanceof Player _entity75 && _entity75.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu75) ? _menu75.getMenuState(2, "Investment", 0.0) : 0.0) / 16) * 100) / 100d);
							CustomData.update(DataComponents.CUSTOM_DATA, previewStack, tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "modifier2";
							final double _tagValue = (Math
									.round((((entity instanceof Player _entity77 && _entity77.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu77) ? _menu77.getMenuState(2, "Investment", 0.0) : 0.0) / 16) * 100) / 100d);
							CustomData.update(DataComponents.CUSTOM_DATA, previewStack, tag -> tag.putDouble(_tagName, _tagValue));
						}
					}
					if ((previewStack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality")).equals("Colossal")) {
						{
							final String _tagName = "modifier1";
							final double _tagValue = (Math
									.round((((entity instanceof Player _entity80 && _entity80.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu80) ? _menu80.getMenuState(2, "Investment", 0.0) : 0.0) / 64) * 100) / 100d);
							CustomData.update(DataComponents.CUSTOM_DATA, previewStack, tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "modifier2";
							final double _tagValue = (Math.round((((entity instanceof Player _entity82 && _entity82.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu82) ? _menu82.getMenuState(2, "Investment", 0.0) : 0.0) / 8) * 100)
									/ 100d);
							CustomData.update(DataComponents.CUSTOM_DATA, previewStack, tag -> tag.putDouble(_tagName, _tagValue));
						}
					}
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu) {
					ItemStack _setstack84 = previewStack.copy();
					_setstack84.setCount(1);
					_menu.getSlots().get(2).set(_setstack84);
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