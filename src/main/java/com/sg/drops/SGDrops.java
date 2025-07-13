package com.sg.drops;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceWithEnchantedBonusLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SGDrops implements ModInitializer {
	public static final String MOD_ID = "sg-drops";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
			if (!source.isBuiltin()) {
				return;
			}
			if (EntityType.HUSK.getLootTableKey().get().getValue().toString().contains(key.getValue().toString())) {
				LOGGER.info(key.getValue().toString());
				LootPool.Builder poolBuilder = LootPool.builder()
						.rolls(ConstantLootNumberProvider.create(1))
						.conditionally(RandomChanceWithEnchantedBonusLootCondition.builder(registries, 1f, 0.5f))
						.with(ItemEntry.builder(Items.SAND))
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 5.0f)).build());
				tableBuilder.pool(poolBuilder);
				return;
			}
			if (EntityType.SILVERFISH.getLootTableKey().get().getValue().toString().contains(key.getValue().toString())) {
				LOGGER.info(key.getValue().toString());
				LootPool.Builder poolBuilder = LootPool.builder()
						.rolls(ConstantLootNumberProvider.create(1))
						.conditionally(RandomChanceWithEnchantedBonusLootCondition.builder(registries, 1f, 0.5f))
						.with(ItemEntry.builder(Items.IRON_NUGGET))
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 15.0f)).build());
				tableBuilder.pool(poolBuilder);
				return;
			}
			if (EntityType.ENDER_DRAGON.getLootTableKey().get().getValue().toString().contains(key.getValue().toString())) {
				LOGGER.info(key.getValue().toString());
				LootPool.Builder poolBuilder = LootPool.builder()
						.rolls(ConstantLootNumberProvider.create(1))
						.with(ItemEntry.builder(Items.ELYTRA));
				tableBuilder.pool(poolBuilder);
				return;
			}
			if (EntityType.ENDERMITE.getLootTableKey().get().getValue().toString().contains(key.getValue().toString())) {
				LOGGER.info(key.getValue().toString());
				LootPool.Builder poolBuilder = LootPool.builder()
						.rolls(ConstantLootNumberProvider.create(1))
						.conditionally(RandomChanceWithEnchantedBonusLootCondition.builder(registries, 1f, 0.5f))
						.with(ItemEntry.builder(Items.CHORUS_FRUIT))
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 5.0f)).build());
				tableBuilder.pool(poolBuilder);
				return;
			}
			if (EntityType.ELDER_GUARDIAN.getLootTableKey().get().getValue().toString().contains(key.getValue().toString())) {
				LOGGER.info(key.getValue().toString());
				LootPool.Builder poolBuilder = LootPool.builder()
						.rolls(ConstantLootNumberProvider.create(1))
						.with(ItemEntry.builder(Items.HEART_OF_THE_SEA));
				tableBuilder.pool(poolBuilder);
				return;
			}
			if (EntityType.ELDER_GUARDIAN.getLootTableKey().get().getValue().toString().contains(key.getValue().toString())) {
				LOGGER.info(key.getValue().toString());
				LootPool.Builder poolBuilder = LootPool.builder()
						.rolls(ConstantLootNumberProvider.create(1))
						.with(ItemEntry.builder(Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE));
				tableBuilder.pool(poolBuilder);
				return;
			}
			if (EntityType.MOOSHROOM.getLootTableKey().get().getValue().toString().contains(key.getValue().toString())) {
				LOGGER.info(key.getValue().toString());
				LootPool.Builder poolBuilder = LootPool.builder()
						.rolls(ConstantLootNumberProvider.create(1))
						.conditionally(RandomChanceWithEnchantedBonusLootCondition.builder(registries, 1f, 0.5f))
						.with(ItemEntry.builder(Items.RED_MUSHROOM))
						.with(ItemEntry.builder(Items.BROWN_MUSHROOM))
						.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 5.0f)).build());
				tableBuilder.pool(poolBuilder);
				return;
			}
		});
	}
}