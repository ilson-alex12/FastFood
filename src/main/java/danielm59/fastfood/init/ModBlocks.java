package danielm59.fastfood.init;

import cpw.mods.fml.common.registry.GameRegistry;
import danielm59.fastfood.block.*;
import danielm59.fastfood.block.crops.*;
import danielm59.fastfood.reference.Reference;

@GameRegistry.ObjectHolder(Reference.MODID)
public class ModBlocks {

	public static final BlockFF counter = new BlockCounter();
	public static final BlockFF grinder = new BlockGrinder();
	
	public static void init(){
		
		GameRegistry.registerBlock(counter, "counter");
		GameRegistry.registerBlock(grinder, "grinder");
		
	}
	
}
