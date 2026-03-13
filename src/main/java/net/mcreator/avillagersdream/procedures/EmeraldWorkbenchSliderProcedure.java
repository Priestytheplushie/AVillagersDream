package net.mcreator.avillagersdream.procedures;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.avillagersdream.init.AVillagersDreamModMenus;

public class EmeraldWorkbenchSliderProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double gemAmount = 0;
		gemAmount = itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount();
		if (((entity instanceof Player _entity1 && _entity1.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu1) ? _menu1.getMenuState(2, "Investment", 0.0) : 0.0) > gemAmount) {
			if (entity instanceof Player _player && _player.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu)
				_menu.sendMenuStateUpdate(_player, 2, "Investment", gemAmount, true);
		}
		EmeraldWorkbenchSlot0Procedure.execute(entity);
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}
}