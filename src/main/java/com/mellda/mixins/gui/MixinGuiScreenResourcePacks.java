package com.mellda.mixins.gui;

import com.mellda.modules.ResourcePackFix;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenResourcePacks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiScreenResourcePacks.class)
public class MixinGuiScreenResourcePacks extends GuiScreen {
    @Inject(method = "actionPerformed", at = @At("HEAD"), cancellable = true)
    private void replaceOpener(GuiButton button, CallbackInfo ci) {
        if (button.enabled) {
            if (button.id == 2) {
                if (ResourcePackFix.INSTANCE.isEnabled()){
                    ci.cancel();
                    ResourcePackFix.openFolder();
                }
            }
        }
    }
}