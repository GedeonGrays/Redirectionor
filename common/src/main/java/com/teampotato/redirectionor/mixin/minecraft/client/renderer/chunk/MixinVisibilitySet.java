package com.teampotato.redirectionor.mixin.minecraft.client.renderer.chunk;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.client.renderer.chunk.VisibilitySet;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(VisibilitySet.class)
public abstract class MixinVisibilitySet {
    @Redirect(method = "toString", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private Direction[] implValues() {
        return Redirectionor.DIRECTIONS;
    }
}