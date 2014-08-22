package danielm59.fastfood.init;

import cpw.mods.fml.common.registry.GameRegistry;
import danielm59.fastfood.item.*;
import danielm59.fastfood.item.seed.*;
import danielm59.fastfood.reference.Reference;

@GameRegistry.ObjectHolder(Reference.MODID)
public class ModItems {

	public static final ItemFF knife = new ItemKnife();
	
	public static final ItemSeedFF tomatoseed = new ItemSeedTomato();
	
	public static void init(){
		
		GameRegistry.registerItem(knife, "knife");
		
		GameRegistry.registerItem(tomatoseed, "tomatoseed");
		
	}
	
}
