package net.mcreator.avillagersdream.procedures;

import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.avillagersdream.network.AVillagersDreamModVariables;
import net.mcreator.avillagersdream.init.AVillagersDreamModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EmeraldBarrierDamageBufferProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingIncomingDamageEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double amount) {
		execute(null, world, x, y, z, entity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, double amount) {
		if (entity == null)
			return;
		double actual_blocked_damage = 0;
		double total_shield_hp = 0;
		double emerald_total = 0;
		double slot_index = 0;
		double effective_emeralds = 0;
		double new_heart_level = 0;
		double remaining_ticks = 0;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(AVillagersDreamModMobEffects.EMERALD_BARRIER)) {
			total_shield_hp = entity instanceof Player _plr ? _plr.getAbsorptionAmount() : 0;
			if (amount <= total_shield_hp) {
				actual_blocked_damage = amount;
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, (float) 0.2);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.experience_orb.pickup")), SoundSource.NEUTRAL, 1, (float) 0.2, false);
					}
				}
			} else {
				actual_blocked_damage = total_shield_hp;
			}
			if (!(entity instanceof ServerPlayer _plr3 && _plr3.level() instanceof ServerLevel && _plr3.getAdvancements().getOrStartProgress(_plr3.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:market_crash"))).isDone())
					&& total_shield_hp >= 19 && amount >= total_shield_hp) {
				if (entity instanceof ServerPlayer _player) {
					AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:market_crash"));
					if (_adv != null) {
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			}
			{
				AVillagersDreamModVariables.PlayerVariables _vars = entity.getData(AVillagersDreamModVariables.PLAYER_VARIABLES);
				_vars.EmeraldDebt = entity.getData(AVillagersDreamModVariables.PLAYER_VARIABLES).EmeraldDebt + actual_blocked_damage * 2;
				_vars.markSyncDirty();
			}
			if (!(entity instanceof ServerPlayer _plr5 && _plr5.level() instanceof ServerLevel
					&& _plr5.getAdvancements().getOrStartProgress(_plr5.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:deal_with_the_devil"))).isDone())
					&& entity.getData(AVillagersDreamModVariables.PLAYER_VARIABLES).EmeraldDebt > 500) {
				if (entity instanceof ServerPlayer _player) {
					AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:deal_with_the_devil"));
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