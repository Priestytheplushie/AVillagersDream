/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.avillagersdream.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.avillagersdream.client.renderer.ScoutRenderer;
import net.mcreator.avillagersdream.client.renderer.PriestyRenderer;
import net.mcreator.avillagersdream.client.renderer.DisguisedIllagerRenderer;

@EventBusSubscriber(Dist.CLIENT)
public class AVillagersDreamModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(AVillagersDreamModEntities.PRIESTY.get(), PriestyRenderer::new);
		event.registerEntityRenderer(AVillagersDreamModEntities.DISGUISED_ILLAGER.get(), DisguisedIllagerRenderer::new);
		event.registerEntityRenderer(AVillagersDreamModEntities.SCOUT.get(), ScoutRenderer::new);
	}
}