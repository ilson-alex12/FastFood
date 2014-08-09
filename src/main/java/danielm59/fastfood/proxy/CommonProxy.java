package danielm59.fastfood.proxy;

import cpw.mods.fml.common.registry.GameRegistry;
import danielm59.fastfood.tileentity.TileEntityCounter;

public abstract class CommonProxy implements IProxy {

	public void registerTileEntities() {
		
        GameRegistry.registerTileEntityWithAlternatives(TileEntityCounter.class, "counter", "tile." + "counter");
    
    }
	
}
