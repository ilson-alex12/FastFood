package danielm59.fastfood;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import danielm59.fastfood.handler.ConfigurationHandler;
import danielm59.fastfood.handler.GuiHandler;
import danielm59.fastfood.init.*;
import danielm59.fastfood.proxy.IProxy;
import danielm59.fastfood.reference.Reference;
import danielm59.fastfood.utility.LogHelper;

@Mod(modid = Reference.MODID, name = Reference.MODNAME, version = Reference.VERSION, guiFactory = Reference.GUIFACTORY)
public class FastFood
{
    
    @Mod.Instance(Reference.MODID)
    public static FastFood instance;
    
    @SidedProxy(clientSide = Reference.CPROXY, serverSide = Reference.SPROXY)
    public static IProxy proxy;
    
    @EventHandler
    public void PreInit(FMLPreInitializationEvent event) {
    	
    	ConfigurationHandler.init(event.getSuggestedConfigurationFile());
    	FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
    	ModBlocks.init();
    	ModItems.init();
    	ModFood.init();
    	LogHelper.info("Pre Initialization Complete!");
    	
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
		
    	Recipes.init();
    	NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
    	proxy.registerTileEntities();
    	LogHelper.info("Initialization Complete!");
    	
    }
    
    @EventHandler
    public void PostInit(FMLPostInitializationEvent event) {
    	
    	LogHelper.info("Post Initialization Complete!");
    	
    }
}
