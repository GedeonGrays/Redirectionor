package com.teampotato.redirectionor.mixin.net.minecraft.world.entity;

import net.minecraft.world.entity.RelativeMovement;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(RelativeMovement.class)
public abstract class RelativeMovementMixin {
    @Unique
    private static final RelativeMovement[] RELATIVE_MOVEMENTS = RelativeMovement.values();
    @Redirect(method = "unpack", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/RelativeMovement;values()[Lnet/minecraft/world/entity/RelativeMovement;"))
    private static RelativeMovement[] redirectRelativeArgument() {
        return RELATIVE_MOVEMENTS;
    }
}
