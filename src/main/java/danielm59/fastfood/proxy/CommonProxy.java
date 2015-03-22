package danielm59.fastfood.proxy;

import net.minecraftforge.fml.common.registry.GameRegistry;
import danielm59.fastfood.tileentity.TileEntityChurn;
import danielm59.fastfood.tileentity.TileEntityCounter;
import danielm59.fastfood.tileentity.TileEntityGrinder;
import danielm59.fastfood.tileentity.TileEntityMill;
import danielm59.fastfood.tileentity.TileEntityPress;

public abstract class CommonProxy implements IProxy {

	public void registerTileEntities() {

		GameRegistry.registerTileEntityWithAlternatives(
				TileEntityCounter.class, "counter", "tile." + "counter");
		GameRegistry.registerTileEntityWithAlternatives(
				TileEntityGrinder.class, "grinder", "tile." + "grinder");
		GameRegistry.registerTileEntityWithAlternatives(TileEntityChurn.class,
				"churn", "tile." + "churn");
		GameRegistry.registerTileEntityWithAlternatives(TileEntityPress.class,
				"press", "tile." + "press");
		GameRegistry.registerTileEntityWithAlternatives(TileEntityMill.class,
				"mill", "tile." + "mill");

	}

}
