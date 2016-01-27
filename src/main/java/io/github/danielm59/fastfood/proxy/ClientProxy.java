package io.github.danielm59.fastfood.proxy;

import io.github.danielm59.fastfood.init.ModBlocks;
import io.github.danielm59.fastfood.init.ModCrops;
import io.github.danielm59.fastfood.init.ModFood;
import io.github.danielm59.fastfood.init.ModItems;

public class ClientProxy extends CommonProxy
{
    
    @Override
    public void loadTextures()
    {
        
        ModBlocks.textures();
        ModItems.textures();
        ModFood.textures();
        ModCrops.textures();
        
    }
    
}
