
package me.alimc2021.super_items.block;

import net.minecraftforge.common.ToolType;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import me.alimc2021.super_items.init.SuperItemsModBlocks;

public class SuperDiamondBlock extends Block {
	public SuperDiamondBlock() {
		super(Block.Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(10f).setRequiresTool().harvestLevel(2).harvestTool(ToolType.PICKAXE).doesNotBlockMovement());
	}

	@Override
	public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player) {
		return new ItemStack(SuperItemsModBlocks.SUPER_DIAMOND.get());
	}
}
