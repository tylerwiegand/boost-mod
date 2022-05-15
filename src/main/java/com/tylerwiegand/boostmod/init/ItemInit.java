package com.tylerwiegand.boostmod.init;

import com.tylerwiegand.boostmod.BoostMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ItemInit {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BoostMod.MOD_ID);

    public static RegistryObject<Item> BOOSTER_ITEM = register("booster", () -> new Item(new Item.Properties().tab(BoostMod.BOOST_TAB)));

    private static <T extends Item> RegistryObject<T> register(String name, Supplier<T> item) {
        return ITEMS.register(name, item);
    }
}
