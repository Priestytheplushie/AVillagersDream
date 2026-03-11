package net.mcreator.avillagersdream.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.avillagersdream.init.AVillagersDreamModMobEffects;
import net.mcreator.avillagersdream.init.AVillagersDreamModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EmeraldArmorFullSetBonusProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == AVillagersDreamModItems.EMERALD_ARMOR_BOOTS.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == AVillagersDreamModItems.EMERALD_ARMOR_LEGGINGS.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == AVillagersDreamModItems.EMERALD_ARMOR_CHESTPLATE.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == AVillagersDreamModItems.EMERALD_ARMOR_HELMET.get()) {
			if (!(entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(AVillagersDreamModMobEffects.EMERALD_BARRIER))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(AVillagersDreamModMobEffects.EMERALD_BARRIER, 300, 0, false, true));
			}
		} else {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(AVillagersDreamModMobEffects.EMERALD_BARRIER);
		}
	}
}