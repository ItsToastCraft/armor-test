package com.toast.armor_test.item;

import com.toast.armor_test.ArmorTest;
import com.toast.armor_test.ArmorTestClient;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.*;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import static com.toast.armor_test.ArmorTest.MOD_ID;

public class HazmatSuitItem extends ArmorItem {
    @Environment(EnvType.CLIENT)
    private BipedEntityModel<LivingEntity> model;

    public HazmatSuitItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }


    @Override
    public ItemStack getDefaultStack() {
        return new ItemStack(this);
    }

    @Override
    public boolean isDamageable() {
        return false;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean canRepair(ItemStack itemStack_1, ItemStack itemStack_2) {
        return false;
    }

    @Environment(EnvType.CLIENT)
    protected BipedEntityModel<LivingEntity> provideArmorModelForSlot(EquipmentSlot slot) {

        var models = MinecraftClient.getInstance().getEntityModelLoader();
        var feet = models.getModelPart(ArmorTestClient.HAZMAT_SUIT_FEET_LAYER);
        var root = models.getModelPart(ArmorTestClient.HAZMAT_SUIT_MAIN_LAYER);
        if (slot == EquipmentSlot.FEET)
            return new FullArmorModel(feet, slot);
        } else {
            return new FullArmorModel(root, slot);
        }
    }

    @Environment(EnvType.CLIENT)
    public BipedEntityModel<LivingEntity> getArmorModel() {
        if (model == null) {
            model = provideArmorModelForSlot(getSlotType());
        }
        return model;
    }

    @NotNull
    public Identifier getArmorTexture(ItemStack stack, EquipmentSlot slot) {
        if (slot == EquipmentSlot.FEET) {
            return new Identifier(MOD_ID, "textures/armor/hazmat_suit_feet.png");
        } else {
            return new Identifier(MOD_ID, "textures/armor/hazmat_suit_main.png");
        }
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return false;
    }
}
