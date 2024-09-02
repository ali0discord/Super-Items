package me.alimc2021.super_items.world.features.ores;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.feature.template.IRuleTestType;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.block.BlockState;

import me.alimc2021.super_items.init.SuperItemsModBlocks;

import java.util.Random;

import com.mojang.serialization.Codec;

@Mod.EventBusSubscriber
public class SuperDiamondFeature {
	private static Feature<OreFeatureConfig> feature = null;
	private static ConfiguredFeature<?, ?> configuredFeature = null;
	private static IRuleTestType<SuperDiamondFeatureRuleTest> CUSTOM_MATCH = null;

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	private static class SuperDiamondFeatureRuleTest extends RuleTest {
		static final SuperDiamondFeatureRuleTest INSTANCE = new SuperDiamondFeatureRuleTest();
		static final Codec<SuperDiamondFeatureRuleTest> codec = Codec.unit(() -> INSTANCE);

		public boolean test(BlockState blockAt, Random random) {
			boolean blockCriteria = false;
			if (BlockTags.getCollection().getTagByID(new ResourceLocation("minecraft:overworld_carver_replaceables")).contains(blockAt.getBlock()))
				blockCriteria = true;
			return blockCriteria;
		}

		protected IRuleTestType<?> getType() {
			return CUSTOM_MATCH;
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	private static class SuperDiamondFeatureRegisterHandler {
		@SubscribeEvent
		public static void registerFeature(RegistryEvent.Register<Feature<?>> event) {
			CUSTOM_MATCH = Registry.register(Registry.RULE_TEST, new ResourceLocation("super_items:super_diamond_match"), () -> SuperDiamondFeatureRuleTest.codec);
			feature = new OreFeature(OreFeatureConfig.CODEC) {
				@Override
				public boolean generate(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, OreFeatureConfig config) {

					return super.generate(world, generator, rand, pos, config);
				}
			};

			configuredFeature = feature.withConfiguration(new OreFeatureConfig(SuperDiamondFeatureRuleTest.INSTANCE, SuperItemsModBlocks.SUPER_DIAMOND.get().getDefaultState(), 16))
					.withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 64))).square().func_242731_b(10);

			event.getRegistry().register(feature.setRegistryName("super_diamond_ores"));
			Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation("super_items:super_diamond_ores"), configuredFeature);
		}
	}

	@SubscribeEvent
	public static void addFeatureToBiomes(BiomeLoadingEvent event) {
		event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> configuredFeature);
	}
}
