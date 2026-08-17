package org.me.altlook.mixins;

import net.minecraft.client.Minecraft;
import net.minecraft.client.MouseHandler;
import net.minecraft.util.Mth;
import org.me.altlook.Altlook;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MouseHandler.class)
public abstract class MouseHandlerMixin {

    @Final
    @Shadow
    private Minecraft minecraft;

    @Inject(method = "turnPlayer(D)V", at = @At("HEAD"), cancellable = true)
    private void altlookTurnPlayer(double d, CallbackInfo ci) {
        if (!Altlook.enabled) return;
        ci.cancel();

        double sensitivity = minecraft.options.sensitivity().get();
        double scale = sensitivity * 0.6 + 0.2;
        double mult = scale * scale * scale * 8.0;

        double dx = ((MouseHandlerAccessor) this).getDX() * mult;
        double dy = ((MouseHandlerAccessor) this).getDY() * mult;

        Altlook.cameraYaw   += dx * 0.15;
        Altlook.cameraPitch += dy * 0.15;
        Altlook.cameraPitch = Mth.clamp(Altlook.cameraPitch, -90, 90);

        ((MouseHandlerAccessor) this).setDX(0);
        ((MouseHandlerAccessor) this).setDY(0);
    }
}