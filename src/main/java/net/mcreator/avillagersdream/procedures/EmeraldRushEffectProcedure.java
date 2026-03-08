package net.mcreator.avillagersdream.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.avillagersdream.network.AVillagersDreamModVariables;
import net.mcreator.avillagersdream.init.AVillagersDreamModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EmeraldRushEffectProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(AVillagersDreamModMobEffects.EMERALD_RUSH)) {
			for (int index0 = 0; index0 < (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(AVillagersDreamModMobEffects.EMERALD_RUSH) ? _livEnt.getEffect(AVillagersDreamModMobEffects.EMERALD_RUSH).getAmplifier() : 0) + 1; index0++) {
				if (Mth.nextInt(RandomSource.create(), 1, 10) == 1) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.EMERALD));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					{
						AVillagersDreamModVariables.PlayerVariables _vars = entity.getData(AVillagersDreamModVariables.PLAYER_VARIABLES);
						_vars.EmeraldRushTriggers = entity.getData(AVillagersDreamModVariables.PLAYER_VARIABLES).EmeraldRushTriggers + 1;
						_vars.markSyncDirty();
					}
				}
				if (!(entity instanceof ServerPlayer _plr4 && _plr4.level() instanceof ServerLevel
						&& _plr4.getAdvancements().getOrStartProgress(_plr4.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:emerald_rush_achivement"))).isDone())) {
					if (entity instanceof ServerPlayer _player) {
						AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:emerald_rush_achivement"));
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
		if (entity.getData(AVillagersDreamModVariables.PLAYER_VARIABLES).EmeraldRushTriggers >= 64 && !(entity instanceof ServerPlayer _plr6 && _plr6.level() instanceof ServerLevel
				&& _plr6.getAdvancements().getOrStartProgress(_plr6.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:emerald_in_the_rough"))).isDone())) {
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:emerald_in_the_rough"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if (entity.getData(AVillagersDreamModVariables.PLAYER_VARIABLES).EmeraldRushTriggers >= 192 && !(entity instanceof ServerPlayer _plr8 && _plr8.level() instanceof ServerLevel
				&& _plr8.getAdvancements().getOrStartProgress(_plr8.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:emerald_in_a_haystack"))).isDone())) {
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:emerald_in_a_haystack"));
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