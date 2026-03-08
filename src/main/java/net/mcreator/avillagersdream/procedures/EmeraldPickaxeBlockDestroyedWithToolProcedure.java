package net.mcreator.avillagersdream.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionResult;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.avillagersdream.init.AVillagersDreamModMobEffects;

public class EmeraldPickaxeBlockDestroyedWithToolProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		InteractionResult chance = InteractionResult.PASS;
		if (Mth.nextInt(RandomSource.create(), 1, 10) == 2) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(AVillagersDreamModMobEffects.EMERALD_RUSH, 120, 1));
		}
	}
}