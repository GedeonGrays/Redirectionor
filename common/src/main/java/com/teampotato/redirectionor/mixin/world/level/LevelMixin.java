package com.teampotato.redirectionor.mixin.world.level;

import com.teampotato.redirectionor.references.DirectionReferences;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Level.class)
public abstract class LevelMixin {
    @Redirect(method = "updateNeighbourForOutputSignal", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction$Plane;HORIZONTAL:Lnet/minecraft/core/Direction$Plane;"))
    private Direction.Plane redirectPlaneHORIZONTAL() {
        return DirectionReferences.PlaneReferences.HORIZONTAL;
    }
}