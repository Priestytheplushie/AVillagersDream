package net.mcreator.avillagersdream.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.avillagersdream.AVillagersDreamMod;

public class EmeraldRushMobEffect extends MobEffect {
	public EmeraldRushMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16711783);
		this.withSoundOnAdded(BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.celebrate")));
		this.addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(AVillagersDreamMod.MODID, "effect.emerald_rush_0"), 0.05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(Attributes.BLOCK_BREAK_SPEED, ResourceLocation.fromNamespaceAndPath(AVillagersDreamMod.MODID, "effect.emerald_rush_1"), 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
	}
}