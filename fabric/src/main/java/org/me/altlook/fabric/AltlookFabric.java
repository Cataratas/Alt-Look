package org.me.altlook.fabric;

import net.minecraft.client.KeyMapping;
import net.minecraft.resources.ResourceLocation;
import org.me.altlook.Altlook;
import net.fabricmc.api.ModInitializer;


public final class AltlookFabric implements ModInitializer {
    public static KeyMapping.Category MY_CATEGORY;
    @Override
    public void onInitialize() {
        Altlook.init();
        MY_CATEGORY = KeyMapping.Category.register(ResourceLocation.parse(Altlook.MOD_ID));
    }
}
