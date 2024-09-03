
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

import me.alimc2021.super_items.item.SuperArmmorItem;
import me.alimc2021.super_items.item.SupdiamondItem;
import me.alimc2021.super_items.SuperItemsMod;

public class SuperItemsModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, SuperItemsMod.MODID);
	public static final RegistryObject<Item> SUPER_DIAMOND = block(SuperItemsModBlocks.SUPER_DIAMOND, SuperItemsModTabs.TAB_SUPERBLOCKS);
	public static final RegistryObject<Item> SUPDIAMOND = REGISTRY.register("supdiamond", () -> new SupdiamondItem());
	public static final RegistryObject<Item> SUPER_ARMMOR_HELMET = REGISTRY.register("super_armmor_helmet", () -> new SuperArmmorItem.Helmet());
	public static final RegistryObject<Item> SUPER_ARMMOR_CHESTPLATE = REGISTRY.register("super_armmor_chestplate", () -> new SuperArmmorItem.Chestplate());
	public static final RegistryObject<Item> SUPER_ARMMOR_LEGGINGS = REGISTRY.register("super_armmor_leggings", () -> new SuperArmmorItem.Leggings());
	public static final RegistryObject<Item> SUPER_ARMMOR_BOOTS = REGISTRY.register("super_armmor_boots", () -> new SuperArmmorItem.Boots());

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block, ItemGroup tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().group(tab)));
	}
}
