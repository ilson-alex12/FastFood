package danielm59.fastfood;

import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = FastFood.MODID, name = FastFood.MODNAME, version = FastFood.VERSION)
public class FastFood
{
    //TODO move to reference class
	public static final String MODID = "fastfood";
    public static final String MODNAME = "Fast Food Mod";
    public static final String VERSION = "0.0.1";
    
    @Mod.Instance(FastFood.MODID)
    public static FastFood instance;
    
    @EventHandler
    public void PreInit(FMLPreInitializationEvent event) {
    	
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		
    }
    
    @EventHandler
    public void PostInit(FMLPostInitializationEvent event) {
    	
    }
}
