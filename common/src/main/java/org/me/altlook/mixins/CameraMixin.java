package org.me.altlook.mixins;

import net.minecraft.client.Camera;
import org.joml.Quaternionf;
import org.me.altlook.Altlook;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Camera.class)
public class CameraMixin {
    @Shadow private float xRot;
    @Shadow private float yRot;
    @Final
    @Shadow
    private Quaternionf rotation;

    @Inject(
            method = "setup",
            at = @At("TAIL"),
            cancellable = true)
    private void altlookSetup(CallbackInfo ci) {
        if (!Altlook.enabled) return;
        ci.cancel();

        this.yRot = (float) Altlook.cameraYaw;
        this.xRot = (float) Altlook.cameraPitch;
        this.rotation.rotationYXZ((float)Math.PI - this.yRot * ((float)Math.PI / 180F), -this.xRot * ((float)Math.PI / 180F), 0.0F);
    }
}
