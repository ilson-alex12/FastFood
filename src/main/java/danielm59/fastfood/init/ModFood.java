package danielm59.fastfood.init;

import cpw.mods.fml.common.registry.GameRegistry;
import danielm59.fastfood.item.FoodFF;
import danielm59.fastfood.reference.Reference;

@GameRegistry.ObjectHolder(Reference.MODID)
public class ModFood {

	public static final FoodFF roll = (FoodFF) new FoodFF(1, 0.1F, false).setUnlocalizedName("roll");
	public static final FoodFF rawbacon = (FoodFF) new FoodFF(1, 0.1F, false).setUnlocalizedName("rawbacon");
	public static final FoodFF bacon = (FoodFF) new FoodFF(2, 0.2F, false).setUnlocalizedName("bacon");
	public static final FoodFF baconroll = (FoodFF) new FoodFF(3, 0.3F, false).setUnlocalizedName("baconroll");
	public static final FoodFF rawmince = (FoodFF) new FoodFF(3, 0.3F, false).setUnlocalizedName("rawmince");
	public static final FoodFF rawbeefpatty = (FoodFF) new FoodFF(3, 0.3F, false).setUnlocalizedName("rawbeefpatty");
	public static final FoodFF beefpatty = (FoodFF) new FoodFF(8, 0.8F, false).setUnlocalizedName("beefpatty");
	public static final FoodFF beefburger = (FoodFF) new FoodFF(9, 0.9F, false).setUnlocalizedName("beefburger");
	public static final FoodFF tomato = (FoodFF) new FoodFF(1, 0.1F, false).setUnlocalizedName("tomato");
	
	public static void init(){
		
		GameRegistry.registerItem(roll, "roll");
		GameRegistry.registerItem(rawbacon, "rawbacon");
		GameRegistry.registerItem(bacon, "bacon");
		GameRegistry.registerItem(baconroll, "baconroll");
		GameRegistry.registerItem(rawmince, "rawmince");
		GameRegistry.registerItem(rawbeefpatty, "rawbeefpatty");
		GameRegistry.registerItem(beefpatty, "beefpatty");
		GameRegistry.registerItem(beefburger, "beefburger");
		GameRegistry.registerItem(tomato, "tomato");
		
	}
	
}
