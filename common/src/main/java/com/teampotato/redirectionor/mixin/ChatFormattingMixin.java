package com.teampotato.redirectionor.mixin;

import com.teampotato.redirectionor.references.ChatFormattingReferences;
import net.minecraft.ChatFormatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ChatFormatting.class)
public abstract class ChatFormattingMixin {
    @Redirect(method = {"getById", "getByCode", "getNames"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/ChatFormatting;values()[Lnet/minecraft/ChatFormatting;"))
    private static ChatFormatting[] redirectChatFormattingValues() {
        return ChatFormattingReferences.CHAT_FORMATTINGS;
    }
}
