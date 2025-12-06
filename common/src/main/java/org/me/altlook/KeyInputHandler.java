package org.me.altlook;

import dev.architectury.event.events.client.ClientTickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

import static org.me.altlook.Altlook.MY_KEY;

public class KeyInputHandler {

    public static void register() {
        ClientTickEvent.CLIENT_POST.register(client -> {
            if (MY_KEY != null && MY_KEY.consumeClick()) {
                onPress(client);
            }
        });
    }

    private static void onPress(Minecraft client) {
        assert client.player != null;
        client.player.displayClientMessage(Component.literal("Key pressed!"), false);
    }
}
