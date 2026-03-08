package net.mcreator.avillagersdream.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.avillagersdream.entity.ScoutEntity;

public class ScoutRenderer extends HumanoidMobRenderer<ScoutEntity, HumanoidModel<ScoutEntity>> {
	public ScoutRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<ScoutEntity>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	}

	@Override
	public ResourceLocation getTextureLocation(ScoutEntity entity) {
		return ResourceLocation.parse("a_villagers_dream:textures/entities/whistleblower_2.png");
	}
}