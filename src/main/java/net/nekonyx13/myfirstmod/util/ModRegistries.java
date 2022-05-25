package net.nekonyx13.myfirstmod.util;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.nekonyx13.myfirstmod.entity.ModEntities;
import net.nekonyx13.myfirstmod.entity.custom.GhostyEntity;

public class ModRegistries {
    public static void registerModStuffs() {
        registerAttributes();
    }

    private static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(ModEntities.GHOSTY, GhostyEntity.setAttributes());
    }
}
