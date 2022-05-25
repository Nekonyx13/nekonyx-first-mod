package net.nekonyx13.myfirstmod.entity.client;

import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.nekonyx13.myfirstmod.Main;
import net.nekonyx13.myfirstmod.entity.custom.GhostyEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GhostyRenderer extends GeoEntityRenderer<GhostyEntity> {
    public GhostyRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new GhostyModel());
    }

    @Override
    public Identifier getTexture(GhostyEntity entity) {
        return new Identifier(Main.MOD_ID, "textures/entity/ghosty/ghosty.png");
    }
}
