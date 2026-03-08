package net.mcreator.avillagersdream.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.CrossedArmsItemLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.VillagerModel;

import net.mcreator.avillagersdream.entity.DisguisedIllagerEntity;

import com.mojang.blaze3d.vertex.PoseStack;

public class DisguisedIllagerRenderer extends MobRenderer<DisguisedIllagerEntity, VillagerModel<DisguisedIllagerEntity>> {
	public DisguisedIllagerRenderer(EntityRendererProvider.Context context) {
		super(context, new VillagerModel<DisguisedIllagerEntity>(context.bakeLayer(ModelLayers.VILLAGER)), 0.5f);
		this.addLayer(new CrossedArmsItemLayer<>(this, context.getItemInHandRenderer()));
	}

	@Override
	protected void scale(DisguisedIllagerEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(0.9375f, 0.9375f, 0.9375f);
	}

	@Override
	public ResourceLocation getTextureLocation(DisguisedIllagerEntity entity) {
		return ResourceLocation.parse("a_villagers_dream:textures/entities/nitwitillager.png");
	}
}