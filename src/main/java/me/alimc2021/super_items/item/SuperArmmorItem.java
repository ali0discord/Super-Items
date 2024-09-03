
package me.alimc2021.super_items.item;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.Entity;

import me.alimc2021.super_items.init.SuperItemsModItems;

public abstract class SuperArmmorItem extends ArmorItem {
	public SuperArmmorItem(EquipmentSlotType type, Item.Properties properties) {
		super(new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType type) {
				return new int[]{13, 15, 16, 11}[type.getIndex()] * 15;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType type) {
				return new int[]{0, 4, 5, 1}[type.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 9;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_diamond"));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(SuperItemsModItems.SUPDIAMOND.get()));
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "super_armmor";
			}

			@Override
			public float getToughness() {
				return 0f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		}, type, properties);
	}

	public static class Helmet extends SuperArmmorItem {
		public Helmet() {
			super(EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
			return "super_items:textures/models/armor/test_layer_1.png";
		}
	}

	public static class Chestplate extends SuperArmmorItem {
		public Chestplate() {
			super(EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
			return "super_items:textures/models/armor/test_layer_1.png";
		}
	}

	public static class Leggings extends SuperArmmorItem {
		public Leggings() {
			super(EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
			return "super_items:textures/models/armor/test_layer_2.png";
		}
	}

	public static class Boots extends SuperArmmorItem {
		public Boots() {
			super(EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
			return "super_items:textures/models/armor/test_layer_1.png";
		}
	}
}
