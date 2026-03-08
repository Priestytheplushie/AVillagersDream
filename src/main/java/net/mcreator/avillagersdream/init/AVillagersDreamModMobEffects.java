/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.avillagersdream.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.avillagersdream.potion.EmeraldRushMobEffect;
import net.mcreator.avillagersdream.AVillagersDreamMod;

public class AVillagersDreamModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, AVillagersDreamMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> EMERALD_RUSH = REGISTRY.register("emerald_rush", () -> new EmeraldRushMobEffect());
}