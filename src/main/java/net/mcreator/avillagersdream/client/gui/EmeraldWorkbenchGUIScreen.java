package net.mcreator.avillagersdream.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.client.gui.widget.ExtendedSlider;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.avillagersdream.world.inventory.EmeraldWorkbenchGUIMenu;
import net.mcreator.avillagersdream.procedures.EmeraldWorkbenchQualityDisplayProcedure;
import net.mcreator.avillagersdream.procedures.EmeraldWorkbenchPotencyProcedure;
import net.mcreator.avillagersdream.network.EmeraldWorkbenchGUISliderMessage;
import net.mcreator.avillagersdream.init.AVillagersDreamModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class EmeraldWorkbenchGUIScreen extends AbstractContainerScreen<EmeraldWorkbenchGUIMenu> implements AVillagersDreamModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ExtendedSlider Investment;

	public EmeraldWorkbenchGUIScreen(EmeraldWorkbenchGUIMenu container, Inventory inventory, Component text) {
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
		if (elementType == 2 && elementState instanceof Number n) {
			if (name.equals("Investment"))
				Investment.setValue(n.doubleValue());
		}
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("a_villagers_dream:textures/screens/emerald_workbench_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(ResourceLocation.parse("a_villagers_dream:textures/screens/outputdown.png"), this.leftPos + 23, this.topPos + 37, 0, 0, 16, 24, 16, 24);
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
	public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
		return (this.getFocused() != null && this.isDragging() && button == 0) ? this.getFocused().mouseDragged(mouseX, mouseY, button, dragX, dragY) : super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.a_villagers_dream.emerald_workbench_gui.label_emerald_workbench"), 41, 5, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.a_villagers_dream.emerald_workbench_gui.label_investment"), 64, 22, -12829636, false);
		guiGraphics.drawString(this.font, EmeraldWorkbenchPotencyProcedure.execute(entity), 67, 58, -12829636, false);
		guiGraphics.drawString(this.font, EmeraldWorkbenchQualityDisplayProcedure.execute(entity), 67, 69, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		Investment = new ExtendedSlider(this.leftPos + 65, this.topPos + 34, 98, 20, Component.translatable("gui.a_villagers_dream.emerald_workbench_gui.Investment_prefix"),
				Component.translatable("gui.a_villagers_dream.emerald_workbench_gui.Investment_suffix"), 1, 64, 1, 1, 0, true) {
			@Override
			protected void applyValue() {
				if (!menuStateUpdateActive)
					menu.sendMenuStateUpdate(entity, 2, "Investment", this.getValue(), false);
				PacketDistributor.sendToServer(new EmeraldWorkbenchGUISliderMessage(0, x, y, z, this.getValue()));
				EmeraldWorkbenchGUISliderMessage.handleSliderAction(entity, 0, x, y, z, this.getValue());
			}
		};
		this.addRenderableWidget(Investment);
		if (!menuStateUpdateActive)
			menu.sendMenuStateUpdate(entity, 2, "Investment", Investment.getValue(), false);
	}
}