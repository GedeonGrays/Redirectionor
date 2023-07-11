package com.teampotato.redirectionor.mixin.minecraft.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.AbstractButtonBlock;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = AbstractButtonBlock.class, priority = 10)
public abstract class AbstractButtonBlockMixin {
    @Redirect(method = "getShape", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction$Axis;X:Lnet/minecraft/util/Direction$Axis;"))
    private Direction.Axis implX() {
        return Redirectionor.X;
    }

    @Redirect(method = "<init>", at = @At(value = "FIELD", target = "Lnet/minecraft/state/properties/AttachFace;WALL:Lnet/minecraft/state/properties/AttachFace;"))
    private AttachFace implWall() {
        return Redirectionor.WALL;
    }
}