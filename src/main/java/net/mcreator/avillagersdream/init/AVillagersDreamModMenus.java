/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.avillagersdream.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.Minecraft;

import net.mcreator.avillagersdream.world.inventory.RubyFurnaceGUIMenu;
import net.mcreator.avillagersdream.world.inventory.EmeraldWorkbenchGUIMenu;
import net.mcreator.avillagersdream.network.MenuStateUpdateMessage;
import net.mcreator.avillagersdream.AVillagersDreamMod;

import java.util.Map;

public class AVillagersDreamModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, AVillagersDreamMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<RubyFurnaceGUIMenu>> RUBY_FURNACE_GUI = REGISTRY.register("ruby_furnace_gui", () -> IMenuTypeExtension.create(RubyFurnaceGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<EmeraldWorkbenchGUIMenu>> EMERALD_WORKBENCH_GUI = REGISTRY.register("emerald_workbench_gui", () -> IMenuTypeExtension.create(EmeraldWorkbenchGUIMenu::new));

	public interface MenuAccessor {
		Map<String, Object> getMenuState();

		Map<Integer, Slot> getSlots();

		default void sendMenuStateUpdate(Player player, int elementType, String name, Object elementState, boolean needClientUpdate) {
			getMenuState().put(elementType + ":" + name, elementState);
			if (player instanceof ServerPlayer serverPlayer) {
				PacketDistributor.sendToPlayer(serverPlayer, new MenuStateUpdateMessage(elementType, name, elementState));
			} else if (player.level().isClientSide) {
				if (Minecraft.getInstance().screen instanceof AVillagersDreamModScreens.ScreenAccessor accessor && needClientUpdate)
					accessor.updateMenuState(elementType, name, elementState);
				PacketDistributor.sendToServer(new MenuStateUpdateMessage(elementType, name, elementState));
			}
		}

		default <T> T getMenuState(int elementType, String name, T defaultValue) {
			try {
				return (T) getMenuState().getOrDefault(elementType + ":" + name, defaultValue);
			} catch (ClassCastException e) {
				return defaultValue;
			}
		}
	}
}