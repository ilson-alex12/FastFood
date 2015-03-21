package danielm59.fastfood.init;

import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danielm59.fastfood.item.FoodDrinkableFF;
import danielm59.fastfood.item.FoodFF;
import danielm59.fastfood.reference.Reference;

@GameRegistry.ObjectHolder(Reference.MODID)
public class ModFood {

	
	public static final FoodFF breaddough = 	(FoodFF) new FoodFF			( 1, 0.1F, false).setUnlocalizedName("breaddough");
	public static final FoodFF pizzabase = 		(FoodFF) new FoodFF			( 3, 0.3F, false).setUnlocalizedName("pizzabase");
	public static final FoodFF rawpizza = 		(FoodFF) new FoodFF			( 5, 0.6F, false).setUnlocalizedName("rawpizza");
	public static final FoodFF pizza = 			(FoodFF) new FoodFF			( 8, 0.8F, false).setUnlocalizedName("pizza");
	public static final FoodFF rawbread =		(FoodFF) new FoodFF			( 2, 0.1F, false).setUnlocalizedName("rawbread");
	public static final FoodFF roll =         	(FoodFF) new FoodFF			( 2, 0.3F, false).setUnlocalizedName("roll");
	public static final FoodFF rawbacon =     	(FoodFF) new FoodFF			( 1, 0.1F, false).setUnlocalizedName("rawbacon");
	public static final FoodFF bacon =        	(FoodFF) new FoodFF			( 3, 0.6F, false).setUnlocalizedName("bacon");
	public static final FoodFF baconroll =    	(FoodFF) new FoodFF			( 5, 0.6F, false).setUnlocalizedName("baconroll");
	public static final FoodFF rawmince =     	(FoodFF) new FoodFF			( 2, 0.3F, false).setUnlocalizedName("rawmince");
	public static final FoodFF rawbeefpatty = 	(FoodFF) new FoodFF			( 2, 0.3F, false).setUnlocalizedName("rawbeefpatty");
	public static final FoodFF beefpatty =    	(FoodFF) new FoodFF			( 6, 0.6F, false).setUnlocalizedName("beefpatty");
	public static final FoodFF beefburger =   	(FoodFF) new FoodFF			(10, 0.6F, false).setUnlocalizedName("beefburger");
	public static final FoodFF tomato =       	(FoodFF) new FoodFF			( 1, 0.3F, false).setUnlocalizedName("tomato");
	public static final FoodFF butter =       	(FoodFF) new FoodFF			( 1, 0.1F, false).setUnlocalizedName("butter");
	public static final FoodFF cheese =       	(FoodFF) new FoodFF			( 2, 0.1F, false).setUnlocalizedName("cheese");
	public static final FoodFF gratedcheese = 	(FoodFF) new FoodFF         ( 2, 0.1F, false).setUnlocalizedName("gratedcheese");
	public static final FoodFF tomatosauce =  	(FoodFF) new FoodDrinkableFF( 2, 0.3F, false).setUnlocalizedName("tomatosauce").setContainerItem(Items.glass_bottle);
	
	public static void init(){
		
		GameRegistry.registerItem(breaddough, 	"breaddough");
		GameRegistry.registerItem(pizzabase,	"pizzabase");
		GameRegistry.registerItem(rawpizza,		"rawpizza");
		GameRegistry.registerItem(pizza,		"pizza");
		GameRegistry.registerItem(rawbread,		"rawbread");
		GameRegistry.registerItem(roll, 		"roll");
		GameRegistry.registerItem(rawbacon, 	"rawbacon");
		GameRegistry.registerItem(bacon, 		"bacon");
		GameRegistry.registerItem(baconroll,	"baconroll");
		GameRegistry.registerItem(rawmince, 	"rawmince");
		GameRegistry.registerItem(rawbeefpatty, "rawbeefpatty");
		GameRegistry.registerItem(beefpatty, 	"beefpatty");
		GameRegistry.registerItem(beefburger,	"beefburger");
		GameRegistry.registerItem(tomato, 		"tomato");
		GameRegistry.registerItem(butter, 		"butter");
		GameRegistry.registerItem(cheese, 		"cheese");
		GameRegistry.registerItem(gratedcheese, "gratedcheese");
		GameRegistry.registerItem(tomatosauce, 	"tomatosauce");
		
	}
	
}
