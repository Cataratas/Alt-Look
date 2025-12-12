package org.me.altlook;

import net.minecraft.client.*;

public final class Altlook {
    public static final String MOD_ID = "altlook";
    public static KeyMapping MY_KEY;
    public static boolean enabled;
    public static double cameraPitch;
    public static double cameraYaw;

    public static void init() {
        // Write common init code here.
        KeyInputHandler.register();
    }
}
