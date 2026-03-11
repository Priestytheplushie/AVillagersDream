/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.avillagersdream.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.avillagersdream.item.*;
import net.mcreator.avillagersdream.AVillagersDreamMod;

public class AVillagersDreamModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(AVillagersDreamMod.MODID);
	public static final DeferredItem<Item> EMERALD_SWORD;
	public static final DeferredItem<Item> EMERALD_PICKAXE;
	public static final DeferredItem<Item> EMERALD_AXE;
	public static final DeferredItem<Item> EMERALD_UPGRADE;
	public static final DeferredItem<Item> EMERALD_INGOT;
	public static final DeferredItem<Item> PRIESTY_SPAWN_EGG;
	public static final DeferredItem<Item> RUBY;
	public static final DeferredItem<Item> EMERALD_HOE;
	public static final DeferredItem<Item> EMERALD_NUGGET;
	public static final DeferredItem<Item> EMERALD_SHOVEL;
	public static final DeferredItem<Item> RUBY_FURNACE;
	public static final DeferredItem<Item> RUBY_EMERALD;
	public static final DeferredItem<Item> DISGUISED_ILLAGER_SPAWN_EGG;
	public static final DeferredItem<Item> SCOUT_SPAWN_EGG;
	public static final DeferredItem<Item> EMERALD_WORKBENCH;
	public static final DeferredItem<Item> EMERALD_ARMOR_HELMET;
	public static final DeferredItem<Item> EMERALD_ARMOR_CHESTPLATE;
	public static final DeferredItem<Item> EMERALD_ARMOR_LEGGINGS;
	public static final DeferredItem<Item> EMERALD_ARMOR_BOOTS;
	static {
		EMERALD_SWORD = REGISTRY.register("emerald_sword", EmeraldSwordItem::new);
		EMERALD_PICKAXE = REGISTRY.register("emerald_pickaxe", EmeraldPickaxeItem::new);
		EMERALD_AXE = REGISTRY.register("emerald_axe", EmeraldAxeItem::new);
		EMERALD_UPGRADE = REGISTRY.register("emerald_upgrade", EmeraldUpgradeItem::new);
		EMERALD_INGOT = REGISTRY.register("emerald_ingot", EmeraldIngotItem::new);
		PRIESTY_SPAWN_EGG = REGISTRY.register("priesty_spawn_egg", () -> new DeferredSpawnEggItem(AVillagersDreamModEntities.PRIESTY, -3407719, -13159, new Item.Properties()));
		RUBY = REGISTRY.register("ruby", RubyItem::new);
		EMERALD_HOE = REGISTRY.register("emerald_hoe", EmeraldHoeItem::new);
		EMERALD_NUGGET = REGISTRY.register("emerald_nugget", EmeraldNuggetItem::new);
		EMERALD_SHOVEL = REGISTRY.register("emerald_shovel", EmeraldShovelItem::new);
		RUBY_FURNACE = block(AVillagersDreamModBlocks.RUBY_FURNACE, new Item.Properties().fireResistant());
		RUBY_EMERALD = REGISTRY.register("ruby_emerald", RubyEmeraldItem::new);
		DISGUISED_ILLAGER_SPAWN_EGG = REGISTRY.register("disguised_illager_spawn_egg", () -> new DeferredSpawnEggItem(AVillagersDreamModEntities.DISGUISED_ILLAGER, -6724096, -16776961, new Item.Properties()));
		SCOUT_SPAWN_EGG = REGISTRY.register("scout_spawn_egg", () -> new DeferredSpawnEggItem(AVillagersDreamModEntities.SCOUT, -10066330, -6710887, new Item.Properties()));
		EMERALD_WORKBENCH = block(AVillagersDreamModBlocks.EMERALD_WORKBENCH);
		EMERALD_ARMOR_HELMET = REGISTRY.register("emerald_armor_helmet", EmeraldArmorItem.Helmet::new);
		EMERALD_ARMOR_CHESTPLATE = REGISTRY.register("emerald_armor_chestplate", EmeraldArmorItem.Chestplate::new);
		EMERALD_ARMOR_LEGGINGS = REGISTRY.register("emerald_armor_leggings", EmeraldArmorItem.Leggings::new);
		EMERALD_ARMOR_BOOTS = REGISTRY.register("emerald_armor_boots", EmeraldArmorItem.Boots::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}