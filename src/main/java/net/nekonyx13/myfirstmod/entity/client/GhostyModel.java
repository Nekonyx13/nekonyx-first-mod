package net.nekonyx13.myfirstmod.entity.client;

import net.minecraft.util.Identifier;
import net.nekonyx13.myfirstmod.Main;
import net.nekonyx13.myfirstmod.entity.custom.GhostyEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class GhostyModel extends AnimatedGeoModel<GhostyEntity> {
    @Override
    public Identifier getModelLocation(GhostyEntity object) {
        return new Identifier(Main.MOD_ID, "geo/ghosty.geo.json");
    }

    @Override
    public Identifier getTextureLocation(GhostyEntity object) {
        return new Identifier(Main.MOD_ID, "textures/entity/ghosty/ghosty.png");
    }

    @Override
    public Identifier getAnimationFileLocation(GhostyEntity animatable) {
        return new Identifier(Main.MOD_ID, "animations/ghosty.animation.json");
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setLivingAnimations(GhostyEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getBone("all");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if(head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
