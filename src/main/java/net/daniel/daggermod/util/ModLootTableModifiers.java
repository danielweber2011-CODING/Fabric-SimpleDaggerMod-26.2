package net.daniel.daggermod.util;

import net.daniel.daggermod.item.ModItems;
import net.fabricmc.fabric.api.loot.v3.FabricLootTableBuilder;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public class ModLootTableModifiers {
    public static void modifyLootTables(ResourceKey<LootTable> key, FabricLootTableBuilder builder,
                                        LootTableSource source, HolderLookup.Provider provider) {

        if (BuiltInLootTables.SIMPLE_DUNGEON.equals(key)||BuiltInLootTables.BASTION_TREASURE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.50f))
                    .add(LootItem.lootTableItem(ModItems.DAGGER_UPGRADE_TEMPLATE));
        }
        if (BuiltInLootTables.BASTION_BRIDGE.equals(key)) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1))
                    .when(LootItemRandomChanceCondition.randomChance(0.50f))
                    .add(LootItem.lootTableItem(ModItems.GOLD_DAGGER));
        }
    }
}
