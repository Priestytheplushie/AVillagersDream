package net.mcreator.avillagersdream.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class RubyFurnaceGUIArrow1TooltipProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		return Math.round((getBlockNBTNumber(world, BlockPos.containing(x, y, z), "cookTime") / 200) * 100) + "%";
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}