package net.daniel.daggermod.item;

import net.daniel.daggermod.DaggerMod;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

import java.util.function.Function;

public class ModItems {
    public static Item DAGGER_UPGRADE_TEMPLATE = registerItem("dagger_upgrade_template", Item::new);
    public static Item WOODEN_DAGGER = registerItem("wooden_dagger", properties -> new Item(properties.sword(ToolMaterial.WOOD, 2, -1.2f)));
    public static Item COPPER_DAGGER = registerItem("copper_dagger", properties -> new Item(properties.sword(ToolMaterial.COPPER,2,-1.2f)));
    public static Item IRON_DAGGER = registerItem("iron_dagger", properties -> new Item(properties.sword(ToolMaterial.IRON,2,-1.2f)));
    public static Item GOLD_DAGGER = registerItem("gold_dagger", properties -> new Item(properties.sword(ToolMaterial.GOLD,2,-1.2f)));
    public static Item DIAMOND_DAGGER = registerItem("diamond_dagger", properties -> new Item(properties.sword(ToolMaterial.DIAMOND,2,-1.2f)));
    public static Item NETHERITE_DAGGER = registerItem("netherite_dagger", properties -> new Item(properties.sword(ToolMaterial.NETHERITE,2,-1.2f)));


    public static ResourceKey<Item> getRK(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).get();
    }

    public static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(DaggerMod.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(DaggerMod.MOD_ID, name)))));
    }

    public static void registerModItems() {
        DaggerMod.LOGGER.info("Registering Mod Items for " + DaggerMod.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> {
            output.accept(WOODEN_DAGGER);
            output.accept(COPPER_DAGGER);
            output.accept(IRON_DAGGER);
            output.accept(GOLD_DAGGER);
            output.accept(DIAMOND_DAGGER);
            output.accept(NETHERITE_DAGGER);

        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(DAGGER_UPGRADE_TEMPLATE);
        });
    }
}