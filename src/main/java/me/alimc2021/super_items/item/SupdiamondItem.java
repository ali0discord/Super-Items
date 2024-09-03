
package me.alimc2021.super_items.item;

import net.minecraft.item.Rarity;
import net.minecraft.item.Item;

import me.alimc2021.super_items.init.SuperItemsModTabs;

public class SupdiamondItem extends Item {
	public SupdiamondItem() {
		super(new Item.Properties().group(SuperItemsModTabs.TAB_SUPER_ITEM).maxStackSize(64).rarity(Rarity.COMMON));
	}
}
