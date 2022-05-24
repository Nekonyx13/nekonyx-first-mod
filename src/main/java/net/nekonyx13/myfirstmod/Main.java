package net.nekonyx13.myfirstmod;

import net.fabricmc.api.ModInitializer;
import net.nekonyx13.myfirstmod.blocks.ModBlocks;
import net.nekonyx13.myfirstmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {
    public static final String MOD_ID = "myfirstmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
    }
}
