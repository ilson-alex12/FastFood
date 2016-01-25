package danielm59.fastfood.proxy;

import danielm59.fastfood.init.ModBlocks;
import danielm59.fastfood.init.ModCrops;
import danielm59.fastfood.init.ModFood;
import danielm59.fastfood.init.ModItems;

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
