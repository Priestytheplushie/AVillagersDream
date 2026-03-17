/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.avillagersdream.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.avillagersdream.AVillagersDreamMod;

@EventBusSubscriber
public class AVillagersDreamModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AVillagersDreamMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> A_VILLAGERS_DREAM = REGISTRY.register("a_villagers_dream",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.a_villagers_dream.a_villagers_dream")).icon(() -> new ItemStack(Items.EMERALD)).displayItems((parameters, tabData) -> {
				tabData.accept(AVillagersDreamModItems.EMERALD_SWORD.get());
				tabData.accept(AVillagersDreamModItems.EMERALD_PICKAXE.get());
				tabData.accept(AVillagersDreamModItems.EMERALD_AXE.get());
				tabData.accept(AVillagersDreamModItems.EMERALD_HOE.get());
				tabData.accept(AVillagersDreamModItems.EMERALD_SHOVEL.get());
				tabData.accept(AVillagersDreamModItems.EMERALD_UPGRADE.get());
				tabData.accept(AVillagersDreamModItems.EMERALD_INGOT.get());
				tabData.accept(AVillagersDreamModItems.RUBY.get());
				tabData.accept(AVillagersDreamModItems.EMERALD_NUGGET.get());
				tabData.accept(AVillagersDreamModBlocks.RUBY_FURNACE.get().asItem());
				tabData.accept(AVillagersDreamModItems.DISGUISED_ILLAGER_SPAWN_EGG.get());
				tabData.accept(AVillagersDreamModBlocks.EMERALD_WORKBENCH.get().asItem());
				tabData.accept(AVillagersDreamModItems.EMERALD_ARMOR_HELMET.get());
				tabData.accept(AVillagersDreamModItems.EMERALD_ARMOR_CHESTPLATE.get());
				tabData.accept(AVillagersDreamModItems.EMERALD_ARMOR_LEGGINGS.get());
				tabData.accept(AVillagersDreamModItems.EMERALD_ARMOR_BOOTS.get());
				tabData.accept(AVillagersDreamModItems.SCOUT_SPAWN_EGG.get());
				tabData.accept(AVillagersDreamModItems.EMERALD_MACE.get());
			}).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(AVillagersDreamModItems.EMERALD_SWORD.get());
			tabData.accept(AVillagersDreamModItems.EMERALD_ARMOR_HELMET.get());
			tabData.accept(AVillagersDreamModItems.EMERALD_ARMOR_CHESTPLATE.get());
			tabData.accept(AVillagersDreamModItems.EMERALD_ARMOR_LEGGINGS.get());
			tabData.accept(AVillagersDreamModItems.EMERALD_ARMOR_BOOTS.get());
			tabData.accept(AVillagersDreamModItems.EMERALD_MACE.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(AVillagersDreamModItems.EMERALD_UPGRADE.get());
			tabData.accept(AVillagersDreamModItems.RUBY.get());
			tabData.accept(AVillagersDreamModItems.EMERALD_NUGGET.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
			tabData.accept(AVillagersDreamModBlocks.RUBY_FURNACE.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(AVillagersDreamModItems.DISGUISED_ILLAGER_SPAWN_EGG.get());
			tabData.accept(AVillagersDreamModItems.SCOUT_SPAWN_EGG.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(AVillagersDreamModItems.EMERALD_AXE.get());
			tabData.accept(AVillagersDreamModItems.EMERALD_PICKAXE.get());
			tabData.accept(AVillagersDreamModItems.EMERALD_HOE.get());
			tabData.accept(AVillagersDreamModItems.EMERALD_SHOVEL.get());
		}
	}
}