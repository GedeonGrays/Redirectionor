package com.teampotato.redirectionor.mixin.net.minecraft.world.level.block.state.pattern;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlockPattern.class)
public abstract class BlockPatternMixin {
    @Redirect(method = "find", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private Direction[] redirectDirection() {
        return Redirectionor.DIRECTIONS;
    }
}
