package net.mcreator.avillagersdream.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ExperienceOrb;
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
import net.mcreator.avillagersdream.init.AVillagersDreamModMenus;

public class EmeraldWorkbenchTransactionProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack current_item = ItemStack.EMPTY;
		double slotcount = 0;
		slotcount = getAmountInGUISlot(entity, 1);
		if (entity instanceof Player _player && _player.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu) {
			_menu.getSlots().get(1).remove((int) ((entity instanceof Player _entity1 && _entity1.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu1) ? _menu1.getMenuState(2, "Investment", 0.0) : 0.0));
			_menu.getSlots().get(0).remove(1);
			_player.containerMenu.broadcastChanges();
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, (float) 0.3);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.use")), SoundSource.NEUTRAL, 1, (float) 0.3, false);
			}
		}
		if (world instanceof ServerLevel _level)
			_level.addFreshEntity(new ExperienceOrb(_level, x, (y + 1), z, (int) slotcount));
		{
			AVillagersDreamModVariables.PlayerVariables _vars = entity.getData(AVillagersDreamModVariables.PLAYER_VARIABLES);
			_vars.EmeraldsInvested = entity.getData(AVillagersDreamModVariables.PLAYER_VARIABLES).EmeraldsInvested
					+ ((entity instanceof Player _entity6 && _entity6.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu6) ? _menu6.getMenuState(2, "Investment", 0.0) : 0.0);
			_vars.markSyncDirty();
		}
		if (!(entity instanceof ServerPlayer _plr7 && _plr7.level() instanceof ServerLevel && _plr7.getAdvancements().getOrStartProgress(_plr7.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:the_art_of_the_deal"))).isDone())) {
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:the_art_of_the_deal"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if (!(entity instanceof ServerPlayer _plr9 && _plr9.level() instanceof ServerLevel && _plr9.getAdvancements().getOrStartProgress(_plr9.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:all_in"))).isDone())
				&& slotcount == 64) {
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:all_in"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if (!(entity instanceof ServerPlayer _plr11 && _plr11.level() instanceof ServerLevel && _plr11.getAdvancements().getOrStartProgress(_plr11.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:startup_invester"))).isDone())
				&& entity.getData(AVillagersDreamModVariables.PLAYER_VARIABLES).EmeraldsInvested >= 200) {
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:startup_invester"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if (!(entity instanceof ServerPlayer _plr13 && _plr13.level() instanceof ServerLevel && _plr13.getAdvancements().getOrStartProgress(_plr13.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:venture_capitalist"))).isDone())
				&& entity.getData(AVillagersDreamModVariables.PLAYER_VARIABLES).EmeraldsInvested >= 500) {
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:venture_capitalist"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if (!(entity instanceof ServerPlayer _plr15 && _plr15.level() instanceof ServerLevel && _plr15.getAdvancements().getOrStartProgress(_plr15.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:the_emerald_whale"))).isDone())
				&& entity.getData(AVillagersDreamModVariables.PLAYER_VARIABLES).EmeraldsInvested >= 1000) {
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:the_emerald_whale"));
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

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof Player player && player.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor menuAccessor) {
			ItemStack stack = menuAccessor.getSlots().get(sltid).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}
}