package danielm59.fastfood.item.seed;

import danielm59.fastfood.init.ModCrops;
import net.minecraft.init.Blocks;

public class ItemSeedTomato extends ItemSeedFF
{
    
    public ItemSeedTomato()
    {
        
        super(ModCrops.tomatocrop, Blocks.farmland);
        this.setUnlocalizedName("tomatoseeds");
        
    }
    
}
