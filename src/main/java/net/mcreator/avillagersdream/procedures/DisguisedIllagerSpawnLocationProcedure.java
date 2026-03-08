package net.mcreator.avillagersdream.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.avillagersdream.entity.DisguisedIllagerEntity;

public class DisguisedIllagerSpawnLocationProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level0 && _level0.isVillage(BlockPos.containing(x, y, z)) && Math.random() < 0.05
				&& !world.getEntitiesOfClass(DisguisedIllagerEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(64 / 2d), e -> true).isEmpty()) {
			return true;
		}
		return false;
	}
}