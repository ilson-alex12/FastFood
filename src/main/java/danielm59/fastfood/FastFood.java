package danielm59.fastfood;

import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import danielm59.fastfood.handler.ConfigurationHandler;
import danielm59.fastfood.proxy.IProxy;
import danielm59.fastfood.reference.Reference;

@Mod(modid = Reference.MODID, name = Reference.MODNAME, version = Reference.VERSION)
public class FastFood
{
    
    @Mod.Instance(Reference.MODID)
    public static FastFood instance;
    
    @SidedProxy(clientSide = Reference.CPROXY, serverSide = Reference.SPROXY)
    public static IProxy proxy;
    
    @EventHandler
    public void PreInit(FMLPreInitializationEvent event) {
    	
    	ConfigurationHandler.init(event.getSuggestedConfigurationFile());
    	
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		
    }
    
    @EventHandler
    public void PostInit(FMLPostInitializationEvent event) {
    	
    }
}
