package net.daniel.daggermod;

import net.daniel.daggermod.datagen.ModAdvancementsProvider;
import net.daniel.daggermod.datagen.ModItemTagsProvider;
import net.daniel.daggermod.datagen.ModModelProvider;
import net.daniel.daggermod.datagen.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DaggerModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		var pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModItemTagsProvider::new);
		pack.addProvider(ModAdvancementsProvider::new);
	}
}