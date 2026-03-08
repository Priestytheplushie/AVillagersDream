package net.mcreator.avillagersdream.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.avillagersdream.world.inventory.RubyFurnaceGUIMenu;
import net.mcreator.avillagersdream.procedures.*;
import net.mcreator.avillagersdream.init.AVillagersDreamModScreens;

import java.util.stream.Collectors;
import java.util.Arrays;

import com.mojang.blaze3d.systems.RenderSystem;

public class RubyFurnaceGUIScreen extends AbstractContainerScreen<RubyFurnaceGUIMenu> implements AVillagersDreamModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;

	public RubyFurnaceGUIScreen(RubyFurnaceGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("a_villagers_dream:textures/screens/ruby_furnace_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (FurnaceFlameProcedureProcedure.execute(world, x, y, z))
			if (mouseX > leftPos + 37 && mouseX < leftPos + 61 && mouseY > topPos + 33 && mouseY < topPos + 57) {
				String hoverText = RubyFurnaceGUIFlameValueProcedure.execute(world, x, y, z);
				if (hoverText != null) {
					guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
				}
				customTooltipShown = true;
			}
		if (FurnaceArrow1ProcedureProcedure.execute(world, x, y, z))
			if (mouseX > leftPos + 74 && mouseX < leftPos + 98 && mouseY > topPos + 24 && mouseY < topPos + 48) {
				String hoverText = RubyFurnaceGUIArrow1TooltipProcedure.execute(world, x, y, z);
				if (hoverText != null) {
					guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
				}
				customTooltipShown = true;
			}
		if (FurnaceArrow2ProcedureProcedure.execute(world, x, y, z))
			if (mouseX > leftPos + 74 && mouseX < leftPos + 98 && mouseY > topPos + 48 && mouseY < topPos + 72) {
				String hoverText = RubyFurnaceGUIArrow2TooltipProcedure.execute(world, x, y, z);
				if (hoverText != null) {
					guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
				}
				customTooltipShown = true;
			}
		if (!customTooltipShown)
			this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(ResourceLocation.parse("a_villagers_dream:textures/screens/unlit.png"), this.leftPos + 38, this.topPos + 37, 0, 0, 22, 17, 22, 17);
		if (FurnaceFlameProcedureProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("a_villagers_dream:textures/screens/lit_progress.png"), this.leftPos + 43, this.topPos + 38, 0, 0, 14, 14, 14, 14);
		}
		guiGraphics.blit(ResourceLocation.parse("a_villagers_dream:textures/screens/burn_progress_1.png"), this.leftPos + 73, this.topPos + 31, 0, 0, 24, 16, 24, 16);
		guiGraphics.blit(ResourceLocation.parse("a_villagers_dream:textures/screens/burn_progress_1.png"), this.leftPos + 73, this.topPos + 47, 0, 0, 24, 16, 24, 16);
		if (FurnaceArrow1ProcedureProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("a_villagers_dream:textures/screens/burnprogress2.png"), this.leftPos + 73, this.topPos + 31, 0, 0, 24, 16, 24, 16);
		}
		if (FurnaceArrow2ProcedureProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("a_villagers_dream:textures/screens/burnprogress2.png"), this.leftPos + 73, this.topPos + 48, 0, 0, 24, 16, 24, 16);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.a_villagers_dream.ruby_furnace_gui.label_inventory"), 8, 72, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.a_villagers_dream.ruby_furnace_gui.label_ruby_furnace"), 54, 6, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}