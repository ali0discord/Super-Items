
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package me.alimc2021.super_items.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.RegistryObject;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.Block;

import me.alimc2021.super_items.SuperItemsMod;

public class SuperItemsModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, SuperItemsMod.MODID);
	public static final RegistryObject<Item> SUPER_DIAMOND = block(SuperItemsModBlocks.SUPER_DIAMOND, SuperItemsModTabs.TAB_SUPERBLOCKS);

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block, ItemGroup tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().group(tab)));
	}
}
