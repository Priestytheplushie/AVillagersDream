package net.mcreator.avillagersdream.procedures;

import net.neoforged.neoforge.event.ItemAttributeModifierEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CalculateAttributeModifiersProcedure {
	@SubscribeEvent
	public static void addAttributeModifier(ItemAttributeModifierEvent event) {
		execute(event, event.getItemStack());
	}

	public static void execute(ItemStack itemstack) {
		execute(null, itemstack);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack) {
		if (!itemstack.has(DataComponents.CUSTOM_DATA) || !itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().contains("emeraldQuality")) {
			return;
		}
		if (event instanceof ItemAttributeModifierEvent _event) {
			EquipmentSlotGroup equipmentSlot = EquipmentSlotGroup.MAINHAND;
			if ((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality")).equals("Bulky")) {
				_event.addModifier(BuiltInRegistries.ATTRIBUTE.getHolder(ResourceLocation.parse("minecraft:generic.armor")).get(),
						(new AttributeModifier(ResourceLocation.parse(("a_villagers_dream:" + "bulky_armor").toLowerCase(java.util.Locale.ENGLISH)),
								(double) (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("modifier1")), AttributeModifier.Operation.ADD_VALUE)),
						equipmentSlot);
				_event.addModifier(BuiltInRegistries.ATTRIBUTE.getHolder(ResourceLocation.parse("minecraft:generic.attack_speed")).get(), (new AttributeModifier(
						ResourceLocation.parse(("a_villagers_dream:" + "hasty").toLowerCase(java.util.Locale.ENGLISH)),
						(double) (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("modifier2") - itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("modifier2") * 2),
						AttributeModifier.Operation.ADD_VALUE)), equipmentSlot);
			}
			if ((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality")).equals("Sturdy")) {
				_event.addModifier(BuiltInRegistries.ATTRIBUTE.getHolder(ResourceLocation.parse("minecraft:generic.armor_toughness")).get(),
						(new AttributeModifier(ResourceLocation.parse(("a_villagers_dream:" + "sturdy_toughness").toLowerCase(java.util.Locale.ENGLISH)),
								(double) (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("modifier1")), AttributeModifier.Operation.ADD_VALUE)),
						equipmentSlot);
				_event.addModifier(BuiltInRegistries.ATTRIBUTE.getHolder(ResourceLocation.parse("minecraft:generic.knockback_resistance")).get(),
						(new AttributeModifier(ResourceLocation.parse(("a_villagers_dream:" + "sturdy_knockback").toLowerCase(java.util.Locale.ENGLISH)),
								(double) (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("modifier2")), AttributeModifier.Operation.ADD_VALUE)),
						equipmentSlot);
			}
			if ((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality")).equals("Greedy")) {
				_event.addModifier(BuiltInRegistries.ATTRIBUTE.getHolder(ResourceLocation.parse("minecraft:generic.luck")).get(),
						(new AttributeModifier(ResourceLocation.parse(("a_villagers_dream:" + "greedy_luck").toLowerCase(java.util.Locale.ENGLISH)),
								(double) (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("modifier1")), AttributeModifier.Operation.ADD_VALUE)),
						equipmentSlot);
			}
			if ((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality")).equals("Prosperous")) {
				_event.addModifier(BuiltInRegistries.ATTRIBUTE.getHolder(ResourceLocation.parse("minecraft:generic.max_health")).get(),
						(new AttributeModifier(ResourceLocation.parse(("a_villagers_dream:" + "prosperous_health").toLowerCase(java.util.Locale.ENGLISH)),
								(double) (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("modifier1")), AttributeModifier.Operation.ADD_VALUE)),
						equipmentSlot);
			}
			if ((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality")).equals("Long")) {
				_event.addModifier(BuiltInRegistries.ATTRIBUTE.getHolder(ResourceLocation.parse("minecraft:player.entity_interaction_range")).get(),
						(new AttributeModifier(ResourceLocation.parse(("a_villagers_dream:" + "long").toLowerCase(java.util.Locale.ENGLISH)),
								(double) (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("modifier1")), AttributeModifier.Operation.ADD_VALUE)),
						equipmentSlot);
			}
			if ((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality")).equals("Sharp")) {
				_event.addModifier(BuiltInRegistries.ATTRIBUTE.getHolder(ResourceLocation.parse("minecraft:generic.attack_damage")).get(),
						(new AttributeModifier(ResourceLocation.parse(("a_villagers_dream:" + "sharp").toLowerCase(java.util.Locale.ENGLISH)),
								(double) (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("modifier1")), AttributeModifier.Operation.ADD_VALUE)),
						equipmentSlot);
			}
			if ((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality")).equals("Hasty")) {
				_event.addModifier(BuiltInRegistries.ATTRIBUTE.getHolder(ResourceLocation.parse("minecraft:generic.attack_speed")).get(),
						(new AttributeModifier(ResourceLocation.parse(("a_villagers_dream:" + "hasty").toLowerCase(java.util.Locale.ENGLISH)),
								(double) (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("modifier1")), AttributeModifier.Operation.ADD_VALUE)),
						equipmentSlot);
			}
			if ((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("emeraldQuality")).equals("Heavy")) {
				_event.addModifier(BuiltInRegistries.ATTRIBUTE.getHolder(ResourceLocation.parse("minecraft:generic.attack_knockback")).get(),
						(new AttributeModifier(ResourceLocation.parse(("a_villagers_dream:" + "heavy_kb").toLowerCase(java.util.Locale.ENGLISH)),
								(double) (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("modifier1")), AttributeModifier.Operation.ADD_VALUE)),
						equipmentSlot);
				_event.addModifier(BuiltInRegistries.ATTRIBUTE.getHolder(ResourceLocation.parse("minecraft:generic.attack_speed")).get(), (new AttributeModifier(
						ResourceLocation.parse(("a_villagers_dream:" + "bulky_slowness").toLowerCase(java.util.Locale.ENGLISH)),
						(double) (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("modifier2") - itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("modifier2") * 2),
						AttributeModifier.Operation.ADD_VALUE)), equipmentSlot);
			}
		}
	}
}