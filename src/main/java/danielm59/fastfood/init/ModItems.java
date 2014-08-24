package danielm59.fastfood.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;
import danielm59.fastfood.item.*;
import danielm59.fastfood.item.seed.*;
import danielm59.fastfood.reference.Reference;

@GameRegistry.ObjectHolder(Reference.MODID)
public class ModItems {

	public static final ItemFF knife = new ItemKnife();
	
	public static final ItemSeedFF tomatoseeds = new ItemSeedTomato();
	
	public static void init(){
		
		GameRegistry.registerItem(knife, "knife");
		
		GameRegistry.registerItem(tomatoseeds, "tomatoseeds");
		MinecraftForge.addGrassSeed(new ItemStack(tomatoseeds), 10);
		
	}
	
}
