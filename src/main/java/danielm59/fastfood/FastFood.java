package danielm59.fastfood;

import danielm59.fastfood.handler.ConfigurationHandler;
import danielm59.fastfood.handler.GuiHandler;
import danielm59.fastfood.init.ModBlocks;
import danielm59.fastfood.init.ModCrops;
import danielm59.fastfood.init.ModFood;
import danielm59.fastfood.init.ModItems;
import danielm59.fastfood.init.Recipes;
import danielm59.fastfood.proxy.IProxy;
import danielm59.fastfood.reference.Reference;
import io.github.danielm59.m59Libs.utility.LogHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = Reference.MODID, name = Reference.MODNAME, version = Reference.VERSION, guiFactory = Reference.GUIFACTORY, dependencies = "required-after:m59Libs")
public class FastFood
{
    
    @Mod.Instance(Reference.MODID)
    public static FastFood instance;
                           
    @SidedProxy(clientSide = Reference.CPROXY, serverSide = Reference.SPROXY)
    public static IProxy   proxy;
                           
    @EventHandler
    public void PreInit(FMLPreInitializationEvent event)
    {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        MinecraftForge.EVENT_BUS.register(new ConfigurationHandler());
        ModBlocks.init();
        ModItems.init();
        ModFood.init();
        ModCrops.init();
        LogHelper.info("Pre Initialization Complete!");
        
    }
    
    @EventHandler
    public void Init(FMLInitializationEvent event)
    {
        
        Recipes.init();
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
        proxy.registerTileEntities();
        proxy.loadTextures();
        LogHelper.info("Initialization Complete!");
        
    }
    
    @EventHandler
    public void PostInit(FMLPostInitializationEvent event)
    {
        
        LogHelper.info("Post Initialization Complete!");
        
    }
}
