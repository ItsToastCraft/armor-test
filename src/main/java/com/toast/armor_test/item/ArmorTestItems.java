package com.toast.armor_test.item;

import com.toast.armor_test.ArmorTest;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ArmorTestItems {
    public static final Item HAZMAT_HELMET = new HazmatSuitItem(ArmorMaterials.LEATHER, ArmorItem.Type.HELMET, new FabricItemSettings().rarity(Rarity.RARE));
    public static final Item HAZMAT_CHESTPLATE = new HazmatSuitItem(ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().rarity(Rarity.RARE));
    public static final Item HAZMAT_LEGGINGS = new HazmatSuitItem(ArmorMaterials.LEATHER, ArmorItem.Type.LEGGINGS, new FabricItemSettings().rarity(Rarity.RARE));
    public static final Item HAZMAT_BOOTS = new HazmatSuitItem(ArmorMaterials.LEATHER, ArmorItem.Type.BOOTS, new FabricItemSettings().rarity(Rarity.RARE));

    public static void registerItems() {
        registerItem("hazmat_suit_helmet", HAZMAT_HELMET);
        registerItem("hazmat_suit_chestplate", HAZMAT_CHESTPLATE);
        registerItem("hazmat_suit_leggings", HAZMAT_LEGGINGS);
        registerItem("hazmat_suit_boots", HAZMAT_BOOTS);
    }
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(ArmorTest.MOD_ID, name), item);
    }
}
