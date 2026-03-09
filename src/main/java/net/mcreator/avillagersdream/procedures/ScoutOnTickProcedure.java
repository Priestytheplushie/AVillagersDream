package net.mcreator.avillagersdream.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.avillagersdream.entity.ScoutEntity;

import java.util.Comparator;

public class ScoutOnTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity player = null;
		double random = 0;
		double buffed = 0;
		double playersFound = 0;
		if (entity.getPersistentData().getDouble("hornTimer") > 0) {
			entity.getPersistentData().putDouble("hornTimer", (entity.getPersistentData().getDouble("hornTimer") - 1));
		} else if (entity.getPersistentData().getBoolean("isCharging") == false) {
			entity.getPersistentData().putBoolean("isCharging", true);
			entity.getPersistentData().putDouble("chargeTimer", 40);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 5, false, false));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 200, 1, false, false));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.pillager.celebrate")), SoundSource.HOSTILE, 2, 1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.pillager.celebrate")), SoundSource.HOSTILE, 2, 1, false);
				}
			}
			if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
				ItemStack _setstack = new ItemStack(Items.GOAT_HORN).copy();
				_setstack.setCount(1);
				_modHandler.setStackInSlot(0, _setstack);
			}
		} else if (entity.getPersistentData().getBoolean("isCharging") == true) {
			entity.getPersistentData().putDouble("chargeTimer", (entity.getPersistentData().getDouble("chargeTimer") - 1));
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.NOTE, (entity.getX()), (entity.getY()), (entity.getZ()), 8, 1, 1, 0.5, 1);
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			if (entity.getPersistentData().getDouble("chargeTimer") <= 0 && !world.getEntitiesOfClass(Player.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(24 / 2d), e -> true).isEmpty()) {
				entity.getPersistentData().putBoolean("isCharging", false);
				entity.getPersistentData().putDouble("hornTimer", 300);
				player = findEntityInWorldRange(world, Player.class, x, y, z, 16);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.goat_horn.sound.2")), SoundSource.HOSTILE, 2, 1);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.goat_horn.sound.2")), SoundSource.HOSTILE, 2, 1, false);
					}
				}
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
					ItemStack _setstack = new ItemStack(Blocks.AIR).copy();
					_setstack.setCount(1);
					_modHandler.setStackInSlot(0, _setstack);
				}
				{
					final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(24 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (entityiterator.getType().is(EntityTypeTags.ILLAGER)) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.bell.resonate")),
											SoundSource.NEUTRAL, 2, 1);
								} else {
									_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.bell.resonate")), SoundSource.NEUTRAL, 2, 1, false);
								}
							}
							if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 200, 1, false, false));
							if (!(entityiterator instanceof ScoutEntity)) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 0, false, true));
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1, false, true));
								buffed = buffed + 1;
							}
							if (entityiterator instanceof Mob _entity && player instanceof LivingEntity _ent)
								_entity.setTarget(_ent);
						}
					}
				}
				if (buffed == 0) {
					random = Mth.nextInt(RandomSource.create(), 1, 4);
					if (Mth.nextInt(RandomSource.create(), 1, 4) == 1) {
						for (int index0 = 0; index0 < 3; index0++) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.PILLAGER.spawn(_level,
										BlockPos.containing(x + Mth.nextInt(RandomSource.create(), 0, 6) - 3, entity.getY() + Mth.nextInt(RandomSource.create(), 0, 2), z + Mth.nextInt(RandomSource.create(), 0, 6) - 3), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						}
					} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 2) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.VINDICATOR.spawn(_level,
									BlockPos.containing(x + Mth.nextInt(RandomSource.create(), 0, 6) - 3, entity.getY() + Mth.nextInt(RandomSource.create(), 0, 2), z + Mth.nextInt(RandomSource.create(), 0, 6) - 3), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setDeltaMovement(0, 0, 0);
							}
						}
						for (int index1 = 0; index1 < 2; index1++) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.PILLAGER.spawn(_level,
										BlockPos.containing(x + Mth.nextInt(RandomSource.create(), 0, 6) - 3, entity.getY() + Mth.nextInt(RandomSource.create(), 0, 2), z + Mth.nextInt(RandomSource.create(), 0, 6) - 3), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						}
					} else if (Mth.nextInt(RandomSource.create(), 1, 4) == 3) {
						for (int index2 = 0; index2 < 3; index2++) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.VINDICATOR.spawn(_level,
										BlockPos.containing(x + Mth.nextInt(RandomSource.create(), 0, 6) - 3, entity.getY() + Mth.nextInt(RandomSource.create(), 0, 2), z + Mth.nextInt(RandomSource.create(), 0, 6) - 3), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						}
					} else if (Mth.nextInt(RandomSource.create(), 1, 4) >= 4) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = EntityType.WITCH.spawn(_level,
									BlockPos.containing(x + Mth.nextInt(RandomSource.create(), 0, 6) - 3, entity.getY() + Mth.nextInt(RandomSource.create(), 0, 2), z + Mth.nextInt(RandomSource.create(), 0, 6) - 3), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setDeltaMovement(0, 0, 0);
							}
						}
						for (int index3 = 0; index3 < 2; index3++) {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = EntityType.VINDICATOR.spawn(_level,
										BlockPos.containing(x + Mth.nextInt(RandomSource.create(), 0, 6) - 3, entity.getY() + Mth.nextInt(RandomSource.create(), 0, 2), z + Mth.nextInt(RandomSource.create(), 0, 6) - 3), MobSpawnType.MOB_SUMMONED);
								if (entityToSpawn != null) {
									entityToSpawn.setDeltaMovement(0, 0, 0);
								}
							}
						}
					}
					{
						final Vec3 _center = new Vec3(x, y, z);
						for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
							if (entityiterator.getType().is(EntityTypeTags.ILLAGER)) {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(entityiterator.getX(), entityiterator.getY(), entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.bell.resonate")),
												SoundSource.NEUTRAL, 2, 1);
									} else {
										_level.playLocalSound((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.bell.resonate")), SoundSource.NEUTRAL, 2, 1,
												false);
									}
								}
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 200, 1, false, false));
								if (!(entityiterator instanceof ScoutEntity)) {
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 0, false, true));
									if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
										_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1, false, true));
									buffed = buffed + 1;
								}
								if (entityiterator instanceof Mob _entity && player instanceof LivingEntity _ent)
									_entity.setTarget(_ent);
							}
						}
					}
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 120, 1, false, false));
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 120, 1, false, false));
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.GLOWING);
				}
			}
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}