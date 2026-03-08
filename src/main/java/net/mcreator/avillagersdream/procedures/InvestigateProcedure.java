package net.mcreator.avillagersdream.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
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
import net.mcreator.avillagersdream.entity.DisguisedIllagerEntity;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class InvestigateProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		Entity foundEntity = null;
		if ((entity instanceof LivingEntity _entUseItem0 ? _entUseItem0.getUseItem() : ItemStack.EMPTY).getItem() == Items.SPYGLASS) {
			foundEntity = findEntityInWorldRange(world, DisguisedIllagerEntity.class,
					(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(15)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
					(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(15)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
					(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(15)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()), 15);
			if (foundEntity instanceof DisguisedIllagerEntity) {
				foundEntity.getPersistentData().putDouble("spottedTime", (foundEntity.getPersistentData().getDouble("spottedTime") + 1.5));
				if (foundEntity.getPersistentData().getDouble("spottedTime") >= 20 && foundEntity.getPersistentData().getDouble("spottedTime") < 21) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(foundEntity.getX(), foundEntity.getY(), foundEntity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.no")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound((foundEntity.getX()), (foundEntity.getY()), (foundEntity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.no")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				}
				if (foundEntity.getPersistentData().getDouble("spottedTime") > 60 && Math.random() < 0.3 && foundEntity.getPersistentData().getDouble("spottedTime") < 100) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.DRIPPING_WATER, (foundEntity.getX()), (foundEntity.getY()), (foundEntity.getZ()), 4, 0.5, 1, 0.5, 1);
				}
				if (foundEntity.getPersistentData().getDouble("spottedTime") >= 80 && foundEntity.getPersistentData().getDouble("spottedTime") < 81) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(foundEntity.getX(), foundEntity.getY(), foundEntity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.ambient")), SoundSource.NEUTRAL, 1, 1);
						} else {
							_level.playLocalSound((foundEntity.getX()), (foundEntity.getY()), (foundEntity.getZ()), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.ambient")), SoundSource.NEUTRAL, 1, 1, false);
						}
					}
				}
				if (foundEntity.getPersistentData().getDouble("spottedTime") > 100 && Math.random() < 0.3) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.ANGRY_VILLAGER, (foundEntity.getX()), (foundEntity.getY()), (foundEntity.getZ()), 1, 1, 1, 1, 1);
				}
				if (foundEntity.getPersistentData().getDouble("spottedTime") > 140) {
					if (foundEntity.getPersistentData().getBoolean("spotted") == false) {
						foundEntity.getPersistentData().putBoolean("spotted", true);
						if (foundEntity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 20, 1, false, false));
						{
							AVillagersDreamModVariables.PlayerVariables _vars = entity.getData(AVillagersDreamModVariables.PLAYER_VARIABLES);
							_vars.SpiesCaughtInARow = 1;
							_vars.markSyncDirty();
						}
						foundEntity.getPersistentData().putDouble("agitated", (foundEntity.getPersistentData().getDouble("agitated") + 1));
						if (!(entity instanceof ServerPlayer _plr38 && _plr38.level() instanceof ServerLevel
								&& _plr38.getAdvancements().getOrStartProgress(_plr38.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:under_the_lens"))).isDone())) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:under_the_lens"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
						}
						if (!(entity instanceof ServerPlayer _plr40 && _plr40.level() instanceof ServerLevel
								&& _plr40.getAdvancements().getOrStartProgress(_plr40.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:private_eye"))).isDone())
								&& entity.getData(AVillagersDreamModVariables.PLAYER_VARIABLES).SpiesCaughtInARow >= 10) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:private_eye"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
						}
					} else {
						if (foundEntity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 20, 1, false, false));
					}
				}
			}
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}