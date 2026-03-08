package net.mcreator.avillagersdream.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.avillagersdream.init.AVillagersDreamModItems;

import java.util.Comparator;

public class RubyFurnaceOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == AVillagersDreamModItems.RUBY.get()
				&& getBlockNBTNumber(world, BlockPos.containing(x, y,
						z), "burnTime") <= 0
				&& (world instanceof Level _level4
						&& _level4.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput(
								(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy())), _level4).isPresent()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).getCount() == 0 || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getCount() < (world instanceof Level _lvlSmeltResult
								? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy())), _lvlSmeltResult)
										.map(recipe -> recipe.value().getResultItem(_lvlSmeltResult.registryAccess()).copy()).orElse(ItemStack.EMPTY)
								: ItemStack.EMPTY).getMaxStackSize())
						|| world instanceof Level _level12 && _level12.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy())), _level12).isPresent()
								&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).getCount() == 0 || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getCount() < (world instanceof Level _lvlSmeltResult
										? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy())), _lvlSmeltResult)
												.map(recipe -> recipe.value().getResultItem(_lvlSmeltResult.registryAccess()).copy()).orElse(ItemStack.EMPTY)
										: ItemStack.EMPTY).getMaxStackSize()))) {
			if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
				ItemStack _setstack = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).copy();
				_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() - 1);
				_itemHandlerModifiable.setStackInSlot(2, _setstack);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("burnTime", 1600);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (!((findEntityInWorldRange(world, Player.class, x, y, z, 5)) instanceof ServerPlayer _plr24 && _plr24.level() instanceof ServerLevel
					&& _plr24.getAdvancements().getOrStartProgress(_plr24.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:ruby_heated"))).isDone())) {
				if ((findEntityInWorldRange(world, Player.class, x, y, z, 5)) instanceof ServerPlayer _player) {
					AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:ruby_heated"));
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
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "burnTime") > 0) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("burnTime", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "burnTime") - 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (Math.random() < 0.2) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.LARGE_SMOKE, (x + 0.5), (y + 1.1), (z + 0.5), 1, 0.2, 0.2, 0.2, 0.05);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FLAME, (x + 0.5), (y + 0.9), (z + 0.5), 1, 0.2, 0.2, 0.2, 0.05);
			}
			if (Math.random() < 0.1) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.blastfurnace.fire_crackle")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.blastfurnace.fire_crackle")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			}
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "burnTime") > 0
				&& (world instanceof Level _level35 && _level35.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy())), _level35).isPresent()
						|| world instanceof Level _level37 && _level37.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy())), _level37).isPresent())) {
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getCount() > 0) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("cookTime", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "cookTime") + 3));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount() > 0) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("cookTime2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "cookTime2") + 3));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "cookTime") >= 200) {
				if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getCount() == 0 || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy())
						.getItem() == (world instanceof Level _lvlSmeltResult
								? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy())), _lvlSmeltResult)
										.map(recipe -> recipe.value().getResultItem(_lvlSmeltResult.registryAccess()).copy()).orElse(ItemStack.EMPTY)
								: ItemStack.EMPTY).getItem()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getCount() < (world instanceof Level _lvlSmeltResult
								? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy())), _lvlSmeltResult)
										.map(recipe -> recipe.value().getResultItem(_lvlSmeltResult.registryAccess()).copy()).orElse(ItemStack.EMPTY)
								: ItemStack.EMPTY).getMaxStackSize()) {
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = (world instanceof Level _lvlSmeltResult
								? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy())), _lvlSmeltResult)
										.map(recipe -> recipe.value().getResultItem(_lvlSmeltResult.registryAccess()).copy()).orElse(ItemStack.EMPTY)
								: ItemStack.EMPTY).copy();
						_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(3, _setstack);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount() - 1);
						_itemHandlerModifiable.setStackInSlot(0, _setstack);
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("cookTime", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "cookTime") - 200));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "cookTime2") >= 200) {
				if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getCount() == 0 || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy())
						.getItem() == (world instanceof Level _lvlSmeltResult
								? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy())), _lvlSmeltResult)
										.map(recipe -> recipe.value().getResultItem(_lvlSmeltResult.registryAccess()).copy()).orElse(ItemStack.EMPTY)
								: ItemStack.EMPTY).getItem()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getCount() < (world instanceof Level _lvlSmeltResult
								? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy())), _lvlSmeltResult)
										.map(recipe -> recipe.value().getResultItem(_lvlSmeltResult.registryAccess()).copy()).orElse(ItemStack.EMPTY)
								: ItemStack.EMPTY).getMaxStackSize()) {
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = (world instanceof Level _lvlSmeltResult
								? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy())), _lvlSmeltResult)
										.map(recipe -> recipe.value().getResultItem(_lvlSmeltResult.registryAccess()).copy()).orElse(ItemStack.EMPTY)
								: ItemStack.EMPTY).copy();
						_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getCount() + 1);
						_itemHandlerModifiable.setStackInSlot(4, _setstack);
					}
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).copy();
						_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() - 1);
						_itemHandlerModifiable.setStackInSlot(1, _setstack);
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("cookTime2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "cookTime2") - 200));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
		} else {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("cookTime", 0);
					_blockEntity.getPersistentData().putDouble("cookTime2", 0);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getCount() >= 1 && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount() >= 1
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getCount() > 0 && !((findEntityInWorldRange(world, Player.class, x, y, z, 5)) instanceof ServerPlayer _plr99 && _plr99.level() instanceof ServerLevel
						&& _plr99.getAdvancements().getOrStartProgress(_plr99.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:maximum_throughput"))).isDone())) {
			if ((findEntityInWorldRange(world, Player.class, x, y, z, 5)) instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("a_villagers_dream:maximum_throughput"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "burnTime") > 0) {
			{
				int _value = 1;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		} else {
			{
				int _value = 0;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		}
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}