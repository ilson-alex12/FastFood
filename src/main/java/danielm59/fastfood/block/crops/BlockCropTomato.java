package danielm59.fastfood.block.crops;

import danielm59.fastfood.init.ModCrops;
import danielm59.fastfood.init.ModFood;

public class BlockCropTomato extends BlockCropsFF {

	public BlockCropTomato() {
		
		super();
		this.setSeed(ModCrops.tomatoseeds);
		this.setDrop(ModFood.tomato);
		
	}
	
}
