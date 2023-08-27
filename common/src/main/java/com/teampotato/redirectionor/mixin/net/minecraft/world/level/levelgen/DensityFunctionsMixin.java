package com.teampotato.redirectionor.mixin.net.minecraft.world.level.levelgen;

import net.minecraft.world.level.levelgen.DensityFunctions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DensityFunctions.class)
public abstract class DensityFunctionsMixin {
    @Unique private static DensityFunctions.Marker.Type[] DENSITY_FUNCTIONS_MARKER_TYPES = null;

    @Redirect(method = "bootstrap", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/levelgen/DensityFunctions$Marker$Type;values()[Lnet/minecraft/world/level/levelgen/DensityFunctions$Marker$Type;"))
    private static DensityFunctions.Marker.Type[] redirectDensityFunctionsMarkerType() {
        if (DENSITY_FUNCTIONS_MARKER_TYPES == null ) DENSITY_FUNCTIONS_MARKER_TYPES = DensityFunctions.Marker.Type.values();
        return DENSITY_FUNCTIONS_MARKER_TYPES;
    }
}
