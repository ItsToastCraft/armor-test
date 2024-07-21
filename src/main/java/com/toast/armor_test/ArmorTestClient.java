package com.toast.armor_test;

import com.toast.armor_test.render.ArmorTestRenderer;
import com.toast.armor_test.render.HazmatSuitModel;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

import static com.toast.armor_test.ArmorTest.MOD_ID;
@Environment(EnvType.CLIENT)
public class ArmorTestClient implements ClientModInitializer {
	public static final EntityModelLayer HAZMAT_SUIT_FEET_LAYER = new EntityModelLayer(new Identifier(MOD_ID, "hazmat_suit"), "feet");
	public static final EntityModelLayer HAZMAT_SUIT_MAIN_LAYER = new EntityModelLayer(new Identifier(MOD_ID,"hazmat_suit"), "main");

	@Override
	public void onInitializeClient() {
		ArmorTestRenderer.register();
		EntityModelLayerRegistry.registerModelLayer(HAZMAT_SUIT_FEET_LAYER, () -> TexturedModelData.of(HazmatSuitModel.getModelData(), 64, 64));
		EntityModelLayerRegistry.registerModelLayer(HAZMAT_SUIT_MAIN_LAYER, () -> TexturedModelData.of(HazmatSuitModel.getModelData(), 64, 64));
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
	}
}