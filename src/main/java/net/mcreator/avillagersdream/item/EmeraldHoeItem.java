package net.mcreator.avillagersdream.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.*;
import net.minecraft.world.InteractionResult;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.network.chat.Component;

import net.mcreator.avillagersdream.procedures.EmeraldHoeHarvestProcedure;
import net.mcreator.avillagersdream.init.AVillagersDreamModItems;

import java.util.List;

public class EmeraldHoeItem extends HoeItem {
	private static final Tier TOOL_TIER = new Tier() {
		@Override
		public int getUses() {
			return 250;
		}

		@Override
		public float getSpeed() {
			return 6f;
		}

		@Override
		public float getAttackDamageBonus() {
			return 0;
		}

		@Override
		public TagKey<Block> getIncorrectBlocksForDrops() {
			return BlockTags.INCORRECT_FOR_IRON_TOOL;
		}

		@Override
		public int getEnchantmentValue() {
			return 2;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.of(new ItemStack(Items.EMERALD), new ItemStack(AVillagersDreamModItems.EMERALD_INGOT.get()));
		}
	};

	public EmeraldHoeItem() {
		super(TOOL_TIER, new Item.Properties().attributes(DiggerItem.createAttributes(TOOL_TIER, 0f, -1f)));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.a_villagers_dream.emerald_hoe.description_0"));
		list.add(Component.translatable("item.a_villagers_dream.emerald_hoe.description_1"));
		list.add(Component.translatable("item.a_villagers_dream.emerald_hoe.description_2"));
		list.add(Component.translatable("item.a_villagers_dream.emerald_hoe.description_3"));
		list.add(Component.translatable("item.a_villagers_dream.emerald_hoe.description_4"));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		EmeraldHoeHarvestProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}