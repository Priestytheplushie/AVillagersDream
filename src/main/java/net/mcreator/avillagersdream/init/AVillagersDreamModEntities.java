/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.avillagersdream.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.mcreator.avillagersdream.entity.ScoutEntity;
import net.mcreator.avillagersdream.entity.PriestyEntity;
import net.mcreator.avillagersdream.entity.DisguisedIllagerEntity;
import net.mcreator.avillagersdream.AVillagersDreamMod;

@EventBusSubscriber
public class AVillagersDreamModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, AVillagersDreamMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<PriestyEntity>> PRIESTY = register("priesty",
			EntityType.Builder.<PriestyEntity>of(PriestyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.95f));
	public static final DeferredHolder<EntityType<?>, EntityType<DisguisedIllagerEntity>> DISGUISED_ILLAGER = register("disguised_illager",
			EntityType.Builder.<DisguisedIllagerEntity>of(DisguisedIllagerEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.95f));
	public static final DeferredHolder<EntityType<?>, EntityType<ScoutEntity>> SCOUT = register("scout",
			EntityType.Builder.<ScoutEntity>of(ScoutEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.6f, 1.8f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		PriestyEntity.init(event);
		DisguisedIllagerEntity.init(event);
		ScoutEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(PRIESTY.get(), PriestyEntity.createAttributes().build());
		event.put(DISGUISED_ILLAGER.get(), DisguisedIllagerEntity.createAttributes().build());
		event.put(SCOUT.get(), ScoutEntity.createAttributes().build());
	}
}