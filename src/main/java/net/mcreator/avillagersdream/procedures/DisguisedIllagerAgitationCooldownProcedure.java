package net.mcreator.avillagersdream.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class DisguisedIllagerAgitationCooldownProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getDouble("agitationTimer") > 0) {
			entity.getPersistentData().putDouble("agitationTimer", (entity.getPersistentData().getDouble("agitationTimer") - 1));
		} else if (entity.getPersistentData().getDouble("agitated") > 0) {
			entity.getPersistentData().putDouble("agitated", 0);
		}
		if (Math.random() < 0.01) {
			if (Math.random() < 0.01) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.ambient")), SoundSource.HOSTILE, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.illusioner.ambient")), SoundSource.HOSTILE, 1, 1, false);
					}
				}
			}
		}
		if (entity.getPersistentData().getDouble("spottedTime") > 0) {
			entity.getPersistentData().putDouble("spottedTime", (entity.getPersistentData().getDouble("spottedTime") - 0.5));
		}
	}
}