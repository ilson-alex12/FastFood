package danielm59.fastfood.block.crops;

import net.minecraft.item.Item;
import danielm59.fastfood.init.ModCrops;
import danielm59.fastfood.init.ModFood;

public class BlockCropTomato extends BlockCropsFF {

	public BlockCropTomato() {
		
		super();
		this.setBlockName("tomatocrop");
		
	}
	
    @Override
    protected Item func_149866_i() {

    	return ModCrops.tomatoseeds;
    }

    @Override
    protected Item func_149865_P() {

    	return ModFood.tomato;
    }

	
}
