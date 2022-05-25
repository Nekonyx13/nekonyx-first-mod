package net.nekonyx13.myfirstmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.nekonyx13.myfirstmod.entity.ModEntities;
import net.nekonyx13.myfirstmod.entity.client.GhostyRenderer;

public class MainClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.GHOSTY, GhostyRenderer::new);
    }
}
