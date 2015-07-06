package danielm59.fastfood.item.seed;

import net.minecraft.init.Blocks;
import danielm59.fastfood.init.ModCrops;

public class ItemSeedTomato extends ItemSeedFF
{
    
    public ItemSeedTomato()
    {
    
        super(ModCrops.tomatocrop, Blocks.farmland);
        this.setUnlocalizedName("tomatoseeds");
        
    }
    
}
