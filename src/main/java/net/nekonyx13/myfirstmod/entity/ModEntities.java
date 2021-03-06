package net.nekonyx13.myfirstmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nekonyx13.myfirstmod.Main;
import net.nekonyx13.myfirstmod.entity.custom.GhostyEntity;

public class ModEntities {
    public static final EntityType<GhostyEntity> GHOSTY = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(Main.MOD_ID, "ghosty"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, GhostyEntity::new)
                    .dimensions(EntityDimensions.changing(0.5f, 0.5f)).build());
}
