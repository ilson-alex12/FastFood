package danielm59.fastfood.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;
import danielm59.fastfood.block.crops.*;
import danielm59.fastfood.item.seed.*;
import danielm59.fastfood.reference.Reference;

@GameRegistry.ObjectHolder(Reference.MODID)
public class ModCrops {

	public static final BlockCropsFF tomatocrop = new BlockCropTomato();
	public static final ItemSeedFF tomatoseeds = new ItemSeedTomato();
	
	public static void init(){
				
		GameRegistry.registerBlock(tomatocrop, "tomatocrop");
		GameRegistry.registerItem(tomatoseeds, "tomatoseeds");
		MinecraftForge.addGrassSeed(new ItemStack(tomatoseeds), 10);
		
	}
	
}
