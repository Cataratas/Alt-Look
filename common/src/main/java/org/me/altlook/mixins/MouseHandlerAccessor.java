package org.me.altlook.mixins;

import net.minecraft.client.MouseHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(MouseHandler.class)
public interface MouseHandlerAccessor {
    @Accessor("accumulatedDX")
    double getDX();

    @Accessor("accumulatedDY")
    double getDY();

    @Accessor("accumulatedDX")
    void setDX(double v);

    @Accessor("accumulatedDY")
    void setDY(double v);

}