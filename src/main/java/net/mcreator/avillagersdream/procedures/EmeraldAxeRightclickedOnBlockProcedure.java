package net.mcreator.avillagersdream.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

public class EmeraldAxeRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:logs")))) {
			if (itemstack.getDamageValue() == 250) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.break")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.break")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else {
				if (world instanceof ServerLevel _level5 && _level5.isVillage(BlockPos.containing(x, y, z))) {
					if (entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(MobEffects.HERO_OF_THE_VILLAGE)) {
						if (world instanceof ServerLevel _level)
							FallingBlockEntity.fall(_level, BlockPos.containing(x, y, z), Blocks.DEEPSLATE_EMERALD_ORE.defaultBlockState());
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 5, 0.5, 0.5, 0.5, 0.1);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.axe.strip")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.axe.strip")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (world instanceof ServerLevel _level) {
							itemstack.hurtAndBreak(Mth.nextInt(RandomSource.create(), 10, 25), _level, null, _stkprov -> {
							});
						}
						if (!(entity instanceof ServerPlayer _plr13 && _plr13.level() instanceof ServerLevel
								&& _plr13.getAdvancements().getOrStartProgress(_plr13.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:money_does_grow_on_trees"))).isDone())) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:money_does_grow_on_trees"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
						}
						if (!(entity instanceof ServerPlayer _plr15 && _plr15.level() instanceof ServerLevel
								&& _plr15.getAdvancements().getOrStartProgress(_plr15.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:spoils_of_war"))).isDone())) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:spoils_of_war"));
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
						if (Mth.nextDouble(RandomSource.create(), 1, 10) >= 4) {
							if (world instanceof ServerLevel _level)
								FallingBlockEntity.fall(_level, BlockPos.containing(x, y, z), Blocks.DEEPSLATE_EMERALD_ORE.defaultBlockState());
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 5, 0.5, 0.5, 0.5, 0.1);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.axe.strip")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.axe.strip")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
							if (world instanceof ServerLevel _level) {
								itemstack.hurtAndBreak(Mth.nextInt(RandomSource.create(), 10, 25), _level, null, _stkprov -> {
								});
							}
							if (!(entity instanceof ServerPlayer _plr24 && _plr24.level() instanceof ServerLevel
									&& _plr24.getAdvancements().getOrStartProgress(_plr24.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:money_does_grow_on_trees"))).isDone())) {
								if (entity instanceof ServerPlayer _player) {
									AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:money_does_grow_on_trees"));
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
							if (world instanceof ServerLevel _level) {
								itemstack.hurtAndBreak(Mth.nextInt(RandomSource.create(), 2, 7), _level, null, _stkprov -> {
								});
							}
						}
					}
				} else {
					if (Mth.nextInt(RandomSource.create(), 1, 10) == 1) {
						if (world instanceof ServerLevel _level)
							FallingBlockEntity.fall(_level, BlockPos.containing(x, y, z), Blocks.DEEPSLATE_EMERALD_ORE.defaultBlockState());
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 5, 0.5, 0.5, 0.5, 0.1);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.axe.strip")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.axe.strip")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (world instanceof ServerLevel _level) {
							itemstack.hurtAndBreak(Mth.nextInt(RandomSource.create(), 10, 25), _level, null, _stkprov -> {
							});
						}
						if (!(entity instanceof ServerPlayer _plr36 && _plr36.level() instanceof ServerLevel
								&& _plr36.getAdvancements().getOrStartProgress(_plr36.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:money_does_grow_on_trees"))).isDone())) {
							if (entity instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:money_does_grow_on_trees"));
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
						if (world instanceof ServerLevel _level) {
							itemstack.hurtAndBreak(Mth.nextInt(RandomSource.create(), 2, 7), _level, null, _stkprov -> {
							});
						}
					}
				}
			}
		}
	}
}