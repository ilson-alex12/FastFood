package danielm59.fastfood.init;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danielm59.fastfood.block.crops.BlockCropTomato;
import danielm59.fastfood.block.crops.BlockCropsFF;
import danielm59.fastfood.item.seed.ItemSeedFF;
import danielm59.fastfood.item.seed.ItemSeedTomato;
import danielm59.fastfood.reference.Reference;

@GameRegistry.ObjectHolder(Reference.MODID)
public class ModCrops {

	public static final BlockCropsFF tomatocrop = 	new BlockCropTomato();
	public static final ItemSeedFF tomatoseeds = 	new ItemSeedTomato();
	
	public static void init(){
				
		GameRegistry.registerBlock	(tomatocrop, 	"tomatocrop");
		GameRegistry.registerItem	(tomatoseeds, 	"tomatoseeds");
		
		MinecraftForge.addGrassSeed(new ItemStack(tomatoseeds), 10);
		
	}

	
}
