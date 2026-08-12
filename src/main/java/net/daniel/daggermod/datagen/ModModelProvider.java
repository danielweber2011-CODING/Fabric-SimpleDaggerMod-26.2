package net.daniel.daggermod.datagen;

import net.daniel.daggermod.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.WOODEN_DAGGER, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.COPPER_DAGGER, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.IRON_DAGGER, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.GOLD_DAGGER, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.DIAMOND_DAGGER, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.NETHERITE_DAGGER, ModelTemplates.FLAT_ITEM);

        itemModelGenerators.generateFlatItem(ModItems.DAGGER_UPGRADE_TEMPLATE, ModelTemplates.FLAT_ITEM);
    }
}
