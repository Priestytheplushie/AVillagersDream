/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.avillagersdream.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.avillagersdream.client.gui.RubyFurnaceGUIScreen;
import net.mcreator.avillagersdream.client.gui.EmeraldWorkbenchGUIScreen;

@EventBusSubscriber(Dist.CLIENT)
public class AVillagersDreamModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(AVillagersDreamModMenus.RUBY_FURNACE_GUI.get(), RubyFurnaceGUIScreen::new);
		event.register(AVillagersDreamModMenus.EMERALD_WORKBENCH_GUI.get(), EmeraldWorkbenchGUIScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}