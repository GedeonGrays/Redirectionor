package com.teampotato.redirectionor.mixin.net.minecraftforge.client.model;

import net.minecraft.world.item.ItemDisplayContext;
import net.minecraftforge.client.model.SeparateTransformsModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = SeparateTransformsModel.Loader.class, remap = false)
public abstract class SeparateTransformsModelLoaderMixin {
    @Unique private static final ItemDisplayContext[] ITEM_DISPLAY_CONTEXTS = ItemDisplayContext.values();

    @Redirect(method = "read(Lcom/google/gson/JsonObject;Lcom/google/gson/JsonDeserializationContext;)Lnet/minecraftforge/client/model/SeparateTransformsModel;", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemDisplayContext;values()[Lnet/minecraft/world/item/ItemDisplayContext;"))
    private ItemDisplayContext[] redirectTransformTypeValues() {
        return ITEM_DISPLAY_CONTEXTS;
    }
}
