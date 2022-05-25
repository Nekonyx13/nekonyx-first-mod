package net.nekonyx13.myfirstmod.item.custom;

import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtil;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.nekonyx13.myfirstmod.sound.ModSounds;

public class TestRod extends Item {
    private static final int DEATH_RADIUS = 100;

    public TestRod(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (user.getWorld().isClient) {
            user.sendMessage(new TranslatableText("item.myfirstmod.test_rod.killed"), false);
            user.getWorld().playSound(user, user.getBlockPos(), ModSounds.GHOSTY_HURT, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
        entity.damage(DamageSource.GENERIC, entity.getHealth() - 0.5f);
        AreaEffectCloudEntity areaEffectCloudEntity = new AreaEffectCloudEntity(entity.getWorld(), entity.getX(), entity.getY(), entity.getZ());
        areaEffectCloudEntity.setOwner(user);
        areaEffectCloudEntity.setRadius(20.0f);
        areaEffectCloudEntity.setRadiusOnUse(-0.5f);
        areaEffectCloudEntity.setWaitTime(0);
        areaEffectCloudEntity.setDuration(10);
        areaEffectCloudEntity.setRadiusGrowth(-areaEffectCloudEntity.getRadius() / (float)areaEffectCloudEntity.getDuration());
        areaEffectCloudEntity.setColor(0xFF0000);
        // change the color after delay
        areaEffectCloudEntity.setColor(0x4e2F3c);

        entity.onDeath(DamageSource.GENERIC);

        entity.getWorld().getNonSpectatingEntities(LivingEntity.class, new Box(entity.getBlockPos().down(DEATH_RADIUS).east(DEATH_RADIUS).south(DEATH_RADIUS), entity.getBlockPos().up(DEATH_RADIUS).west(DEATH_RADIUS).north(DEATH_RADIUS))).forEach(e -> {
            if (e != user && e != entity) {
                if(user.getWorld().isClient) {
                    user.sendMessage(new TranslatableText("item.myfirstmod.test_rod.killed"), false);
                }
                e.damage(DamageSource.GENERIC, e.getHealth() - 0.5f);
                e.onDeath(DamageSource.GENERIC);
            }
        });

        entity.getWorld().spawnEntity(areaEffectCloudEntity);

        return ActionResult.SUCCESS;
    }
}
