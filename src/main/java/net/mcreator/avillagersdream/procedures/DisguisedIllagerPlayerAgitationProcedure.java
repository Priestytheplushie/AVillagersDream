package net.mcreator.avillagersdream.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

public class DisguisedIllagerPlayerAgitationProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof Player && entity.getPersistentData().getDouble("agitated") > 5 && !sourceentity.isShiftKeyDown() && entity.getPersistentData().getDouble("timer") < 1) {
			if (entity.getPersistentData().getBoolean("isTransforming") == false) {
				DisguisedIllagerTransformProcedure.execute(world, x, y, z, entity, sourceentity);
			}
		} else if (!sourceentity.isShiftKeyDown() && entity.getPersistentData().getDouble("timer") < 1) {
			entity.getPersistentData().putDouble("agitated", (entity.getPersistentData().getDouble("agitated") + 1));
			entity.getPersistentData().putDouble("timer", 40);
			if (entity.getPersistentData().getDouble("agitated") < 3) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.trade")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.trade")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				entity.getPersistentData().putDouble("agitationTimer", 400);
			} else if (entity.getPersistentData().getDouble("agitated") < 5) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.no")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.no")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				entity.getPersistentData().putDouble("agitationTimer", 400);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.ANGRY_VILLAGER, x, y, z, 8, 1, 1, 1, 0.5);
			} else if (entity.getPersistentData().getDouble("timer") > 5) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.ANGRY_VILLAGER, x, y, z, 8, 1, 1, 1, 0.5);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.pillager.celebrate")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.pillager.celebrate")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				DisguisedIllagerTransformProcedure.execute(world, x, y, z, entity, sourceentity);
				if (!(sourceentity instanceof ServerPlayer _plr20 && _plr20.level() instanceof ServerLevel
						&& _plr20.getAdvancements().getOrStartProgress(_plr20.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:false_friends"))).isDone())) {
					if (sourceentity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:false_friends"));
						if (_adv != null) {
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								for (String criteria : _ap.getRemainingCriteria())
									_player.getAdvancements().award(_adv, criteria);
							}
						}
					}
				}
			}
		}
		entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") - 1));
	}
}