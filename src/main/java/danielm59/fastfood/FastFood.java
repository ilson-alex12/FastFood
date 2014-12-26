package danielm59.fastfood;

import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
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
    	ModCrops.init();
    	LogHelper.info("Pre Initialization Complete!");
    	
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
		
    	Recipes.init();
    	NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
    	proxy.registerTileEntities();
    	ModBlocks.textures();
    	ModItems.textures();
    	ModFood.textures();
    	ModCrops.textures();
    	LogHelper.info("Initialization Complete!");
    	
    }
    
    @EventHandler
    public void PostInit(FMLPostInitializationEvent event) {
    	
    	LogHelper.info("Post Initialization Complete!");
    	
    }
}
