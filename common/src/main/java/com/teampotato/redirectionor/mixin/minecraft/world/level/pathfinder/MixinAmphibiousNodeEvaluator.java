package com.teampotato.redirectionor.mixin.minecraft.world.level.pathfinder;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.pathfinder.AmphibiousNodeEvaluator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AmphibiousNodeEvaluator.class)
public abstract class MixinAmphibiousNodeEvaluator {
    @Redirect(method = "getBlockPathType", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private Direction[] implValues() {
        return Redirectionor.DIRECTIONS;
    }

    @Redirect(method = "getNeighbors", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;UP:Lnet/minecraft/core/Direction;"))
    private Direction implUp () {
        return Redirectionor.UP;
    }

    @Redirect(method = "getNeighbors", at = @At(value = "FIELD", target = "Lnet/minecraft/core/Direction;DOWN:Lnet/minecraft/core/Direction;"))
    private Direction implDown() {
        return Redirectionor.DOWN;
    }
}