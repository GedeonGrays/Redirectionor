package com.teampotato.redirectionor.mixin.minecraft.block;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.block.NetherPortalBlock;
import net.minecraft.util.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(NetherPortalBlock.class)
public abstract class NetherPortalBlockMixin {
    @Redirect(method = {"<init>", "rotate"}, at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction$Axis;X:Lnet/minecraft/util/Direction$Axis;"))
    private Direction.Axis implX() {
        return Redirectionor.X;
    }

    @Redirect(method = "rotate", at = @At(value = "FIELD", target = "Lnet/minecraft/util/Direction$Axis;Z:Lnet/minecraft/util/Direction$Axis;"))
    private Direction.Axis implZ() {
        return Redirectionor.Z;
    }
}