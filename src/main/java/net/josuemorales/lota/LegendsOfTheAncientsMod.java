package net.josuemorales.lota;

import com.mojang.logging.LogUtils;
import net.josuemorales.lota.block.ModBlocks;
import net.josuemorales.lota.item.ModCreativeModTabs;
import net.josuemorales.lota.item.ModItems;
import net.josuemorales.lota.worldgen.biome.ModTerrablender;
import net.josuemorales.lota.worldgen.biome.surface.ModSurfaceRules;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(LegendsOfTheAncientsMod.MOD_ID)
public class LegendsOfTheAncientsMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "lota";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();


    public LegendsOfTheAncientsMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get()
                .getModEventBus();

        // Register the Deferred Register for creative tabs
        ModCreativeModTabs.register(modEventBus);
        // Register the Deferred Register for items
        ModItems.register(modEventBus);
        // Register the Deferred Register for blocks
        ModBlocks.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        ModTerrablender.registerBiomes();

        // Register our mod's ForgeConfigSpec so that Forge can create and load the
        // config file for us
        //        ModLoadingContext.get()
        //                .registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID,
                    ModSurfaceRules.makeRules());
        });
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        // If the tab is the Ingredients tab, add the sapphire to it
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            //            event.accept(ModItems.SAPPHIRE);
            //            event.accept(ModItems.RAW_SAPPHIRE);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods
    // in the class annotated with
    // @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
