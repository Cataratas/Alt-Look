package org.me.altlook;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import dev.architectury.event.events.client.ClientTickEvent;
import dev.architectury.utils.ArchitecturyConstants;
import net.minecraft.client.Camera;
import net.minecraft.client.CameraType;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.tutorial.MovementTutorialStepInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundPlayerRotationPacket;
import net.minecraft.world.waypoints.TrackedWaypoint;
import org.lwjgl.glfw.GLFW;

import javax.swing.text.JTextComponent;

public final class Altlook {
    public static final String MOD_ID = "altlook";
    public static KeyMapping MY_KEY;

    public static void init() {
        // Write common init code here.
        KeyInputHandler.register();
    }
}
