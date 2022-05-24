package net.nekonyx13.myfirstmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nekonyx13.myfirstmod.Main;

public class ModItems {
    public static final Item FLAME_CHARM = registerItem("flame_charm",
            new Item(new FabricItemSettings().group(ModItemGroup.MFM_GROUP)));

    public static final Item FLAME_CHARM_HIGH_RES = registerItem("flame_charm_high_res",
            new Item(new FabricItemSettings().group(ModItemGroup.MFM_GROUP)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Main.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Main.LOGGER.info("Registering mod items... for " + Main.MOD_ID);
    }
}
