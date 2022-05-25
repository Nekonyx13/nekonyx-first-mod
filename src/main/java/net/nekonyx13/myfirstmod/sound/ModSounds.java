package net.nekonyx13.myfirstmod.sound;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nekonyx13.myfirstmod.Main;


public class ModSounds {
    public static final SoundEvent GHOSTY_HURT = registerSoundEvent("ghosty_hurt");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(Main.MOD_ID, name);
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(id));
    }

    public static void registerModSounds() {
        Main.LOGGER.info("Registering mod sounds... for " + Main.MOD_ID);
    }
}
