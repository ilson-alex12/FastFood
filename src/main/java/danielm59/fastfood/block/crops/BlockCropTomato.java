package danielm59.fastfood.block.crops;

import danielm59.fastfood.init.ModFood;
import danielm59.fastfood.init.ModItems;

public class BlockCropTomato extends BlockCropsFF {

	public BlockCropTomato() {
		
		super();
		this.setBlockName("tomatocrop");
		this.setSeed(ModItems.tomatoseeds);
		this.setDrop(ModFood.tomato);
		
	}
	
}
