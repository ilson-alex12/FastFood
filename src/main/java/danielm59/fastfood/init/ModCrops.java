package danielm59.fastfood.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.registry.GameRegistry;
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
	
	public static void textures(){
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(tomatoseeds, 0, new ModelResourceLocation("fastfood:tomatoseeds", "inventory"));

		
	}
	
}
