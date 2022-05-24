package net.nekonyx13.myfirstmod.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nekonyx13.myfirstmod.Main;
import net.nekonyx13.myfirstmod.item.ModItemGroup;

public class ModBlocks {
    public static Block CRYSTALLINE_BLOCK = registerBlock("crystalline_block",
            new Block(FabricBlockSettings.
                    of(Material.METAL)
                    .strength(5.0f, 6.0f)
                    .requiresTool()
                    .luminance(6)),
            ModItemGroup.MFM_GROUP);

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(Main.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        Main.LOGGER.info("Registering mod blocks... for " + Main.MOD_ID);
    }
}
