package danielm59.fastfood.init;

import cpw.mods.fml.common.registry.GameRegistry;
import danielm59.fastfood.food.*;
import danielm59.fastfood.reference.Reference;

@GameRegistry.ObjectHolder(Reference.MODID)
public class ModFood {

	public static final FoodFF rawbacon = new FoodRawBacon(1, 1, false);
	
	public static void init(){
		
		GameRegistry.registerItem(rawbacon, "rawbacon");
		
	}
	

}
