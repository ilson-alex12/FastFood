package danielm59.fastfood.item.seed;

import danielm59.fastfood.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class ItemSeedTomato extends ItemSeedFF {

	public ItemSeedTomato() {
		
		super(ModBlocks.tomatocrop, Blocks.farmland);
		this.setUnlocalizedName("tomatoseed");
		
	}

}
