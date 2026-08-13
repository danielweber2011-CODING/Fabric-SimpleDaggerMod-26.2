package net.daniel.daggermod.datagen;

import net.daniel.daggermod.DaggerMod;
import net.daniel.daggermod.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.predicates.ItemPredicate;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementsProvider extends AdvancementProvider {
    public ModAdvancementsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, List.of(new DaggermodAdvancments()));
    }
    public static class DaggermodAdvancments implements AdvancementSubProvider {
        @Override
        public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> output) {
            var items = registries.lookupOrThrow(Registries.ITEM);

            AdvancementHolder root = Advancement.Builder.advancement()
                    .display(
                            ModItems.IRON_DAGGER,
                            Component.translatable("advancements.daggermod.root.title"),
                            Component.translatable("advancements.daggermod.descriptionermod.root"),
                            Identifier.withDefaultNamespace("gui/advancements/backgrounds/adventure"),
                            AdvancementType.TASK,
                            true,
                            false,
                            false
                    )
                    .addCriterion("has_woodendagger", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, ModItems.WOODEN_DAGGER)))
                    .save(output, DaggerMod.MOD_ID + ":daggermod/root");
            AdvancementHolder getGoldenDagger = Advancement.Builder.advancement()
                    .parent(root)
                    .display(
                            ModItems.GOLD_DAGGER,
                            Component.translatable("advancements.daggermod.getGoldDagger.title"),
                            Component.translatable("advancements.daggermod.getGoldDagger.description"),
                            null,
                            AdvancementType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("has_goldendagger", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, ModItems.GOLD_DAGGER)))
                    .save(output, DaggerMod.MOD_ID + ":daggermod/get_gold_dagger");
            AdvancementHolder getNetherDagger = Advancement.Builder.advancement()
                    .parent(root)
                    .display(
                            ModItems.NETHERITE_DAGGER,
                            Component.translatable("advancements.daggermod.getNetherDagger.title"),
                            Component.translatable("advancements.daggermod.getNetherDagger.description"),
                            null,
                            AdvancementType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("has_netherdagger", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, ModItems.NETHERITE_DAGGER)))
                    .save(output, DaggerMod.MOD_ID + ":daggermod/get_nether_dagger");
        }
    }
}
