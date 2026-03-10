/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.mcreator.avillagersdream.init;

import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;

@EventBusSubscriber
public class AVillagersDreamModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == AVillagersDreamModVillagerProfessions.EMERALDSMITH.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.COAL, 16), new ItemStack(Items.EMERALD, 24), new ItemStack(AVillagersDreamModItems.RUBY.get()), 3, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.FLINT, 24), new ItemStack(Items.EMERALD), 8, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.IRON_SHOVEL), new ItemStack(Items.EMERALD, 12), new ItemStack(AVillagersDreamModItems.EMERALD_SHOVEL.get()), 10, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.IRON_INGOT, 12), new ItemStack(Items.EMERALD), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 8), new ItemStack(AVillagersDreamModItems.RUBY.get()), new ItemStack(AVillagersDreamModItems.EMERALD_UPGRADE.get()), 2, 7, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(AVillagersDreamModItems.RUBY.get(), 2), new ItemStack(Items.LAVA_BUCKET), 10, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 12), new ItemStack(Items.IRON_SWORD), new ItemStack(AVillagersDreamModItems.EMERALD_SWORD.get()), 1, 5, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(AVillagersDreamModItems.RUBY.get()), new ItemStack(Items.EMERALD, 8), 8, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 64), new ItemStack(AVillagersDreamModItems.RUBY.get(), 4), new ItemStack(AVillagersDreamModBlocks.RUBY_FURNACE.get()), 1, 15, 0.05f));
		}
	}
}