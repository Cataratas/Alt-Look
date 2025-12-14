package org.me.altlook;

import net.minecraft.client.*;
import net.minecraft.resources.ResourceLocation;

public final class Altlook {
    public static final String MOD_ID = "altlook";
    public static KeyMapping MY_KEY;
    public static boolean enabled;
    public static double cameraPitch;
    public static double cameraYaw;
    public static KeyMapping.Category MY_CATEGORY;

    public static void init() {
        // Write common init code here.
        MY_CATEGORY = KeyMapping.Category.register(ResourceLocation.parse(Altlook.MOD_ID));
        KeyInputHandler.register();
    }
}
