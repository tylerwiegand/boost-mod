package com.tylerwiegand.boostmod.init;

import com.tylerwiegand.boostmod.BoostMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;
import java.util.function.Supplier;

public class BlockInit {
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BoostMod.MOD_ID);
    public static DeferredRegister<Item> ITEMS = ItemInit.ITEMS;

    public static RegistryObject<Block> BOOSTER_BLOCK = register("booster_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLUE)
                    .strength(3.0f)
                    .sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()
            ),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(BoostMod.BOOST_TAB))
    );

    private static <T extends Block> RegistryObject<T> registerBlock(
            String name,
            Supplier<? extends T> block
    ) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(
            String name,
            Supplier<? extends T> block, Function<RegistryObject<T>,
            Supplier<? extends Item>> item
    ) {
        RegistryObject<T> obj = registerBlock(name, block);
        ITEMS.register(name, item.apply(obj));

        return obj;
    }
}
