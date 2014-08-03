package danielm59.fastfood.init;

import cpw.mods.fml.common.registry.GameRegistry;
import danielm59.fastfood.item.FoodFF;
import danielm59.fastfood.reference.Reference;

@GameRegistry.ObjectHolder(Reference.MODID)
public class ModFood {

	public static final FoodFF rawbacon = (FoodFF) new FoodFF(1, 1, false).setUnlocalizedName("rawbacon");
	public static final FoodFF bacon = (FoodFF) new FoodFF(2, 2, false).setUnlocalizedName("bacon");
	
	public static void init(){
		
		GameRegistry.registerItem(rawbacon, "rawbacon");
		GameRegistry.registerItem(bacon, "bacon");
		
	}
	

}
