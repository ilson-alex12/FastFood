package io.github.danielm59.fastfood.proxy;

import io.github.danielm59.fastfood.tileentity.TileEntityChurn;
import io.github.danielm59.fastfood.tileentity.TileEntityCounter;
import io.github.danielm59.fastfood.tileentity.TileEntityFryer;
import io.github.danielm59.fastfood.tileentity.TileEntityGrinder;
import io.github.danielm59.fastfood.tileentity.TileEntityMill;
import io.github.danielm59.fastfood.tileentity.TileEntityPress;
import net.minecraftforge.fml.common.registry.GameRegistry;

public abstract class CommonProxy implements IProxy
{
    
    public void registerTileEntities()
    {
        
        GameRegistry.registerTileEntityWithAlternatives(TileEntityCounter.class, "counter", "tile." + "counter");
        GameRegistry.registerTileEntityWithAlternatives(TileEntityGrinder.class, "grinder", "tile." + "grinder");
        GameRegistry.registerTileEntityWithAlternatives(TileEntityChurn.class, "churn", "tile." + "churn");
        GameRegistry.registerTileEntityWithAlternatives(TileEntityPress.class, "press", "tile." + "press");
        GameRegistry.registerTileEntityWithAlternatives(TileEntityMill.class, "mill", "tile." + "mill");
        GameRegistry.registerTileEntityWithAlternatives(TileEntityFryer.class, "fryer", "tile." + "fryer");
        
    }
    
}
