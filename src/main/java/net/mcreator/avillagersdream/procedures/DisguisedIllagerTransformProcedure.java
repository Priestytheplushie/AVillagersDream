package net.mcreator.avillagersdream.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.Illusioner;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.avillagersdream.network.AVillagersDreamModVariables;
import net.mcreator.avillagersdream.init.AVillagersDreamModItems;
import net.mcreator.avillagersdream.init.AVillagersDreamModEntities;
import net.mcreator.avillagersdream.AVillagersDreamMod;

import java.util.Comparator;

public class DisguisedIllagerTransformProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double x_pos = 0;
		double y_pos = 0;
		double z_pos = 0;
		if (sourceentity instanceof Player) {
			if (entity.getPersistentData().getBoolean("isTransforming") == false) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 120, 5, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 120, 5, false, false));
				entity.getPersistentData().putBoolean("isTransforming", true);
				AVillagersDreamMod.queueServerWork(20, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.prepare_blindness")), SoundSource.HOSTILE, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.prepare_blindness")), SoundSource.HOSTILE, 1, 1, false);
						}
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.ENCHANT, x, y, z, 30, 3, 3, 3, 1);
					AVillagersDreamMod.queueServerWork(20, () -> {
						if (!entity.level().isClientSide())
							entity.discard();
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.LARGE_SMOKE, x, y, z, 25, 0.75, 0.75, 0.75, 0.5);
						if (Mth.nextInt(RandomSource.create(), 1, 10) < 7) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = AVillagersDreamModEntities.SCOUT.get().spawn(_level, BlockPos.containing(x, y + 0.5, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
						} else {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.ILLUSIONER.spawn(_level, BlockPos.containing(x, y + 0.5, z), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
								}
							}
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(AVillagersDreamModItems.RUBY.get()));
							entityToSpawn.setPickUpDelay(60);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.mirror_move")), SoundSource.HOSTILE, 3, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.mirror_move")), SoundSource.HOSTILE, 3, 1, false);
							}
						}
						if ((findEntityInWorldRange(world, Illusioner.class, x, y, z, 4)) instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
							_entity.setTarget(_ent);
						if (!(sourceentity instanceof ServerPlayer _plr16 && _plr16.level() instanceof ServerLevel
								&& _plr16.getAdvancements().getOrStartProgress(_plr16.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:smoke_and_mirrors"))).isDone())) {
							if (sourceentity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:smoke_and_mirrors"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
							{
								AVillagersDreamModVariables.PlayerVariables _vars = sourceentity.getData(AVillagersDreamModVariables.PLAYER_VARIABLES);
								_vars.SpiesCaughtInARow = 0;
								_vars.markSyncDirty();
							}
						}
					});
				});
			}
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}