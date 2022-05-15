package com.tylerwiegand.boostmod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod("boostmod")
public class BoostMod {
    public BoostMod() {
        MinecraftForge.EVENT_BUS.register(this);
    }
}
