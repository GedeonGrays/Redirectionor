package com.teampotato.redirectionor.mixin.net.minecraft.data.loot;

import com.teampotato.redirectionor.Redirectionor;
import net.minecraft.core.Direction;
import net.minecraft.data.loot.BlockLootSubProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlockLootSubProvider.class)
public abstract class BlockLootMixin {
    @Redirect(method = "createMultifaceBlockDrops", at = @At(value = "INVOKE", target = "Lnet/minecraft/core/Direction;values()[Lnet/minecraft/core/Direction;"))
    private static Direction[] redirectDirection() {
        return Redirectionor.DIRECTIONS;
    }
}
