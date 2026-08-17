package org.me.altlook;

import dev.architectury.event.events.client.ClientTickEvent;
import net.minecraft.client.Minecraft;
import static org.me.altlook.Altlook.MY_KEY;
import static org.me.altlook.Altlook.enabled;

public class KeyInputHandler {
    private static boolean reset = true;

    public static void register() {
        ClientTickEvent.CLIENT_POST.register(client -> {
            if (MY_KEY != null && MY_KEY.isDown()) {
                getRotation(client);
                // TODO: save player x and y rotation to reset to and smooth reset
            } else {
                reset = true;
                enabled = false;
            }
        });
    }

    private static void getRotation(Minecraft client) {
        if (client.player == null) return;

        if (reset) {
            Altlook.cameraYaw = client.player.getYRot();
            Altlook.cameraPitch = client.player.getXRot();
            reset = false;
        }
        enabled = true;
    }
}
