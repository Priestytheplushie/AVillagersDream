package net.mcreator.avillagersdream.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
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

public class EmeraldHoeHarvestProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double xOffset = 0;
		double zOffset = 0;
		xOffset = -1;
		zOffset = 0;
		if (entity.isShiftKeyDown()) {
			for (int index0 = 0; index0 < 3; index0++) {
				zOffset = -1;
				for (int index1 = 0; index1 < 3; index1++) {
					if (itemstack.getDamageValue() <= 249) {
						if (world instanceof ServerLevel _level) {
							itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
						if ((world.getBlockState(BlockPos.containing(x + xOffset, y - 1, z + zOffset))).getBlock() == Blocks.GRASS_BLOCK || (world.getBlockState(BlockPos.containing(x + xOffset, y - 1, z + zOffset))).getBlock() == Blocks.DIRT) {
							if (!((world.getBlockState(BlockPos.containing(x + xOffset, y - 1, z + zOffset))).getBlock() == Blocks.AIR)) {
								{
									BlockPos _bp = BlockPos.containing(x + xOffset, y, z + zOffset);
									BlockState _bs = Blocks.FARMLAND.defaultBlockState();
									BlockState _bso = world.getBlockState(_bp);
									for (Property<?> _propertyOld : _bso.getProperties()) {
										Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
										if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
											try {
												_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
											} catch (Exception e) {
											}
									}
									world.setBlock(_bp, _bs, 3);
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.hoe.till")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.hoe.till")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (Mth.nextInt(RandomSource.create(), 1, 10) >= 9) {
									if (world instanceof ServerLevel _level) {
										ItemEntity entityToSpawn = new ItemEntity(_level, (x + xOffset), y, (z + zOffset), new ItemStack(AVillagersDreamModItems.EMERALD_NUGGET.get()));
										entityToSpawn.setPickUpDelay(10);
										_level.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (x + xOffset), y, (z + zOffset), 8, 0.5, 0.5, 0.5, 0.3);
									{
										AVillagersDreamModVariables.PlayerVariables _vars = entity.getData(AVillagersDreamModVariables.PLAYER_VARIABLES);
										_vars.EmeraldNuggetsFromHoe = entity.getData(AVillagersDreamModVariables.PLAYER_VARIABLES).EmeraldNuggetsFromHoe + 1;
										_vars.markSyncDirty();
									}
									if (entity.getData(AVillagersDreamModVariables.PLAYER_VARIABLES).EmeraldNuggetsFromHoe >= 9 && !(entity instanceof ServerPlayer _plr16 && _plr16.level() instanceof ServerLevel
											&& _plr16.getAdvancements().getOrStartProgress(_plr16.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:reaping_the_rewards"))).isDone())) {
										if (entity instanceof ServerPlayer _player) {
											AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:reaping_the_rewards"));
											if (_adv != null) {
												AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
												if (!_ap.isDone()) {
													for (String criteria : _ap.getRemainingCriteria())
														_player.getAdvancements().award(_adv, criteria);
												}
											}
										}
									}
									if (!(entity instanceof ServerPlayer _plr18 && _plr18.level() instanceof ServerLevel
											&& _plr18.getAdvancements().getOrStartProgress(_plr18.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:peak_efficency"))).isDone())) {
										if (entity instanceof ServerPlayer _player) {
											AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:peak_efficency"));
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
						}
						zOffset = zOffset + 1;
					} else {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.break")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.break")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					}
				}
				xOffset = xOffset + 1;
			}
		} else {
			for (int index2 = 0; index2 < 3; index2++) {
				zOffset = -1;
				for (int index3 = 0; index3 < 3; index3++) {
					if (((world.getBlockState(BlockPos.containing(x + xOffset, y, z + zOffset))).getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip22
							? (world.getBlockState(BlockPos.containing(x + xOffset, y, z + zOffset))).getValue(_getip22)
							: -1) >= 7) {
						if (itemstack.getDamageValue() <= 249) {
							if (world instanceof ServerLevel _level) {
								itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
								});
							}
							{
								BlockPos _pos = BlockPos.containing(x + xOffset, y, z + zOffset);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + xOffset, y, z + zOffset), null);
								world.destroyBlock(_pos, false);
							}
							if (Mth.nextInt(RandomSource.create(), 1, 10) >= 8) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, (x + xOffset), y, (z + zOffset), new ItemStack(AVillagersDreamModItems.EMERALD_NUGGET.get()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, (x + xOffset), y, (z + zOffset), 8, 0.5, 0.5, 0.5, 0.3);
								{
									AVillagersDreamModVariables.PlayerVariables _vars = entity.getData(AVillagersDreamModVariables.PLAYER_VARIABLES);
									_vars.EmeraldNuggetsFromHoe = entity.getData(AVillagersDreamModVariables.PLAYER_VARIABLES).EmeraldNuggetsFromHoe + 1;
									_vars.AutomaticOverdrive = entity.getData(AVillagersDreamModVariables.PLAYER_VARIABLES).EmeraldNuggetsFromHoe + 1;
									_vars.markSyncDirty();
								}
								if (entity.getData(AVillagersDreamModVariables.PLAYER_VARIABLES).EmeraldNuggetsFromHoe >= 9 && !(entity instanceof ServerPlayer _plr31 && _plr31.level() instanceof ServerLevel
										&& _plr31.getAdvancements().getOrStartProgress(_plr31.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:reaping_the_rewards"))).isDone())) {
									if (entity instanceof ServerPlayer _player) {
										AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:reaping_the_rewards"));
										if (_adv != null) {
											AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
											if (!_ap.isDone()) {
												for (String criteria : _ap.getRemainingCriteria())
													_player.getAdvancements().award(_adv, criteria);
											}
										}
									}
								}
								if (entity.getData(AVillagersDreamModVariables.PLAYER_VARIABLES).AutomaticOverdrive >= 9 && !(entity instanceof ServerPlayer _plr33 && _plr33.level() instanceof ServerLevel
										&& _plr33.getAdvancements().getOrStartProgress(_plr33.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:automatic_overdrive"))).isDone())) {
									if (entity instanceof ServerPlayer _player) {
										AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:automatic_overdrive"));
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
						} else {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.break")), SoundSource.NEUTRAL, 1, 1);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.item.break")), SoundSource.NEUTRAL, 1, 1, false);
								}
							}
						}
					}
					zOffset = zOffset + 1;
				}
				xOffset = xOffset + 1;
			}
		}
	}
}