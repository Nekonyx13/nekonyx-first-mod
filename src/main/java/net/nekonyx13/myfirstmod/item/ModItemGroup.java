package net.nekonyx13.myfirstmod.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.nekonyx13.myfirstmod.Main;

public class ModItemGroup {
    public static final ItemGroup MFM_GROUP = FabricItemGroupBuilder.build(
            new Identifier(Main.MOD_ID, "mfm_group"),
            () -> new ItemStack(ModItems.FLAME_CHARM));
}
