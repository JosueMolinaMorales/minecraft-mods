package net.josuemorales.lota.item;

import net.josuemorales.lota.LegendsOfTheAncientsMod;
import net.josuemorales.lota.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(
            Registries.CREATIVE_MODE_TAB, LegendsOfTheAncientsMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SWAYS_TAB = CREATIVE_MODE_TABS.register("sways_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.RUNE_STONE_FRAGMENT.get()))
                    .title(Component.translatable("creativetab.sways_tab"))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(new ItemStack(ModBlocks.RUNE_STONE_ORE.get()));
                        pOutput.accept(new ItemStack(ModItems.RUNE_STONE_FRAGMENT.get()));
                        pOutput.accept(new ItemStack(ModItems.RUNE_STONE.get()));

                        pOutput.accept(new ItemStack(ModBlocks.SACRED_GROVE_LEAVES.get()));
                        pOutput.accept(new ItemStack(ModBlocks.STRIPPED_SACRED_GROVE_WOOD.get()));
                        pOutput.accept(new ItemStack(ModBlocks.SACRED_GROVE_LOG.get()));
                        pOutput.accept(new ItemStack(ModBlocks.SACRED_GROVE_WOOD.get()));
                        pOutput.accept(new ItemStack(ModBlocks.SACRED_GROVE_PLANKS.get()));
                        pOutput.accept(new ItemStack(ModBlocks.STRIPPED_SACRED_GROVE_LOG.get()));
                        pOutput.accept(new ItemStack(ModBlocks.SACRED_GROVE_SAPLING.get()));
                    }))
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
