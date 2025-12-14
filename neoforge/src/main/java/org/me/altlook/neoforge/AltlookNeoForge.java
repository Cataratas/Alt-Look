package org.me.altlook.neoforge;

import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;
import org.me.altlook.Altlook;
import net.neoforged.fml.common.Mod;

@Mod(Altlook.MOD_ID)
public final class AltlookNeoForge {
    public AltlookNeoForge() {
        // Run our common setup.
        Altlook.init();

        Altlook.MY_KEY = new KeyMapping(
                    "key.altlook.key",
                    GLFW.GLFW_KEY_LEFT_ALT,
                    Altlook.MY_CATEGORY
            );
    }
}
