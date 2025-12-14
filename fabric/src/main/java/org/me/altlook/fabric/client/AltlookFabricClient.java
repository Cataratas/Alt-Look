package org.me.altlook.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;

import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;
import org.me.altlook.Altlook;

public final class AltlookFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        Altlook.MY_KEY = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                "key.altlook.key",
                GLFW.GLFW_KEY_LEFT_ALT,
                Altlook.MY_CATEGORY
        ));
    }
}
