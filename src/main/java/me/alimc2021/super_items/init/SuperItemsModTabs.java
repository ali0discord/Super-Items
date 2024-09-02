/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package me.alimc2021.super_items.init;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

public class SuperItemsModTabs {
	public static ItemGroup TAB_SUPERBLOCKS;

	public static void load() {
		TAB_SUPERBLOCKS = new ItemGroup("tab_superblocks") {
			@Override
			public ItemStack createIcon() {
				return new ItemStack(SuperItemsModBlocks.SUPER_DIAMOND.get());
			}

			@Override
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
}
