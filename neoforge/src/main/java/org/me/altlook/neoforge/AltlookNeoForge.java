package org.me.altlook.neoforge;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import org.lwjgl.glfw.GLFW;
import org.me.altlook.Altlook;
import net.neoforged.fml.common.Mod;

@Mod(Altlook.MOD_ID)
public final class AltlookNeoForge {
    public static final KeyMapping.Category MY_CATEGORY =
            new KeyMapping.Category(ResourceLocation.fromNamespaceAndPath(Altlook.MOD_ID, "main")
            );

    public AltlookNeoForge(IEventBus modEventBus) {
        Altlook.init();
        modEventBus.addListener(AltlookNeoForge::registerKeyMappings);
    }

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.registerCategory(MY_CATEGORY);

        Altlook.MY_KEY = new KeyMapping("key.altlook.key", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_LEFT_ALT, MY_CATEGORY);
        event.register(Altlook.MY_KEY);
    }
}
