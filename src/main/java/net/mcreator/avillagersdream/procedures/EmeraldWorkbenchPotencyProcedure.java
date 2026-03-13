package net.mcreator.avillagersdream.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.avillagersdream.init.AVillagersDreamModMenus;

public class EmeraldWorkbenchPotencyProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (((entity instanceof Player _entity0 && _entity0.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu0) ? _menu0.getMenuState(2, "Investment", 0.0) : 0.0) < 15) {
			return "Potency: \u00A7aLow";
		} else if (((entity instanceof Player _entity1 && _entity1.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu1) ? _menu1.getMenuState(2, "Investment", 0.0) : 0.0) < 35) {
			return "Potency: \u00A7eNotable";
		} else if (((entity instanceof Player _entity2 && _entity2.containerMenu instanceof AVillagersDreamModMenus.MenuAccessor _menu2) ? _menu2.getMenuState(2, "Investment", 0.0) : 0.0) < 55) {
			return "Potency: \u00A76Extreme";
		}
		return "Potency: \u00A74Legendary";
	}
}