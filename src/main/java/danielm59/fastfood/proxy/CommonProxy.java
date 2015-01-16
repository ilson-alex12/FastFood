package danielm59.fastfood.proxy;

import net.minecraftforge.fml.common.registry.GameRegistry;
import danielm59.fastfood.tileentity.*;

public abstract class CommonProxy implements IProxy {

	public void registerTileEntities() {
		
        GameRegistry.registerTileEntityWithAlternatives(TileEntityCounter.class, "counter", "tile." + "counter");
        GameRegistry.registerTileEntityWithAlternatives(TileEntityGrinder.class, "grinder", "tile." + "grinder");
        GameRegistry.registerTileEntityWithAlternatives(TileEntityChurn.class, "churn", "tile." + "churn");
        
    }
	
}
