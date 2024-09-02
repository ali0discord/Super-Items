/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package me.alimc2021.super_items.init;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.RegistryObject;

import net.minecraft.block.Block;

import me.alimc2021.super_items.block.SuperDiamondBlock;
import me.alimc2021.super_items.SuperItemsMod;

public class SuperItemsModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, SuperItemsMod.MODID);
	public static final RegistryObject<Block> SUPER_DIAMOND = REGISTRY.register("super_diamond", () -> new SuperDiamondBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
