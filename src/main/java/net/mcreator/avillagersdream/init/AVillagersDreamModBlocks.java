/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.avillagersdream.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.avillagersdream.block.RubyFurnaceBlock;
import net.mcreator.avillagersdream.AVillagersDreamMod;

public class AVillagersDreamModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(AVillagersDreamMod.MODID);
	public static final DeferredBlock<Block> RUBY_FURNACE;
	static {
		RUBY_FURNACE = REGISTRY.register("ruby_furnace", RubyFurnaceBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}