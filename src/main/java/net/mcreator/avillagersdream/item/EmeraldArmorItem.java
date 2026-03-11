package net.mcreator.avillagersdream.item;

import net.neoforged.neoforge.registries.RegisterEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Holder;
import net.minecraft.Util;

import net.mcreator.avillagersdream.init.AVillagersDreamModItems;

import java.util.List;
import java.util.EnumMap;

@EventBusSubscriber
public abstract class EmeraldArmorItem extends ArmorItem {
	public static Holder<ArmorMaterial> ARMOR_MATERIAL = null;

	@SubscribeEvent
	public static void registerArmorMaterial(RegisterEvent event) {
		event.register(Registries.ARMOR_MATERIAL, registerHelper -> {
			ArmorMaterial armorMaterial = new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
				map.put(ArmorItem.Type.BOOTS, 2);
				map.put(ArmorItem.Type.LEGGINGS, 5);
				map.put(ArmorItem.Type.CHESTPLATE, 6);
				map.put(ArmorItem.Type.HELMET, 2);
				map.put(ArmorItem.Type.BODY, 6);
			}), 9, DeferredHolder.create(Registries.SOUND_EVENT, ResourceLocation.parse("item.armor.equip_iron")), () -> Ingredient.of(new ItemStack(AVillagersDreamModItems.EMERALD_INGOT.get()), new ItemStack(Items.EMERALD)),
					List.of(new ArmorMaterial.Layer(ResourceLocation.parse("a_villagers_dream:emeraldarmor"))), 2f, 0f);
			registerHelper.register(ResourceLocation.parse("a_villagers_dream:emerald_armor"), armorMaterial);
			ARMOR_MATERIAL = BuiltInRegistries.ARMOR_MATERIAL.wrapAsHolder(armorMaterial);
		});
	}

	public EmeraldArmorItem(ArmorItem.Type type, Item.Properties properties) {
		super(ARMOR_MATERIAL, type, properties);
	}

	public static class Helmet extends EmeraldArmorItem {
		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(15)));
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, list, flag);
			list.add(Component.translatable("item.a_villagers_dream.emerald_armor_helmet.description_0"));
			list.add(Component.translatable("item.a_villagers_dream.emerald_armor_helmet.description_1"));
			list.add(Component.translatable("item.a_villagers_dream.emerald_armor_helmet.description_2"));
			list.add(Component.translatable("item.a_villagers_dream.emerald_armor_helmet.description_3"));
			list.add(Component.translatable("item.a_villagers_dream.emerald_armor_helmet.description_4"));
			list.add(Component.translatable("item.a_villagers_dream.emerald_armor_helmet.description_5"));
		}
	}

	public static class Chestplate extends EmeraldArmorItem {
		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(15)));
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, list, flag);
			list.add(Component.translatable("item.a_villagers_dream.emerald_armor_chestplate.description_0"));
			list.add(Component.translatable("item.a_villagers_dream.emerald_armor_chestplate.description_1"));
			list.add(Component.translatable("item.a_villagers_dream.emerald_armor_chestplate.description_2"));
			list.add(Component.translatable("item.a_villagers_dream.emerald_armor_chestplate.description_3"));
			list.add(Component.translatable("item.a_villagers_dream.emerald_armor_chestplate.description_4"));
			list.add(Component.translatable("item.a_villagers_dream.emerald_armor_chestplate.description_5"));
		}
	}

	public static class Leggings extends EmeraldArmorItem {
		public Leggings() {
			super(ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(15)));
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, list, flag);
			list.add(Component.translatable("item.a_villagers_dream.emerald_armor_leggings.description_0"));
			list.add(Component.translatable("item.a_villagers_dream.emerald_armor_leggings.description_1"));
			list.add(Component.translatable("item.a_villagers_dream.emerald_armor_leggings.description_2"));
			list.add(Component.translatable("item.a_villagers_dream.emerald_armor_leggings.description_3"));
			list.add(Component.translatable("item.a_villagers_dream.emerald_armor_leggings.description_4"));
			list.add(Component.translatable("item.a_villagers_dream.emerald_armor_leggings.description_5"));
		}
	}

	public static class Boots extends EmeraldArmorItem {
		public Boots() {
			super(ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(15)));
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, list, flag);
			list.add(Component.translatable("item.a_villagers_dream.emerald_armor_boots.description_0"));
			list.add(Component.translatable("item.a_villagers_dream.emerald_armor_boots.description_1"));
			list.add(Component.translatable("item.a_villagers_dream.emerald_armor_boots.description_2"));
			list.add(Component.translatable("item.a_villagers_dream.emerald_armor_boots.description_3"));
			list.add(Component.translatable("item.a_villagers_dream.emerald_armor_boots.description_4"));
			list.add(Component.translatable("item.a_villagers_dream.emerald_armor_boots.description_5"));
		}
	}
}