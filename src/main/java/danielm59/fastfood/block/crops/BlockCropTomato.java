package danielm59.fastfood.block.crops;

import danielm59.fastfood.init.ModCrops;
import danielm59.fastfood.init.ModFood;
import net.minecraft.item.Item;

public class BlockCropTomato extends BlockCropsFF
{
    
    public BlockCropTomato()
    {
        
        super();
        
    }
    
    @Override
    protected Item getSeed()
    {
        
        return ModCrops.tomatoseeds;
    }
    
    @Override
    protected Item getCrop()
    {
        
        return ModFood.tomato;
    }
    
}
