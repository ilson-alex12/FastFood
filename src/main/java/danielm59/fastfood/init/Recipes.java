package danielm59.fastfood.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import danielm59.fastfood.recipe.churn.ChurnRegistry;
import danielm59.fastfood.recipe.grinder.GrinderRegistry;
import danielm59.fastfood.recipe.mill.MillRegistry;
import danielm59.fastfood.recipe.press.PressRegistry;

public class Recipes {

	public static void init() {
		
		GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.counter, 	"sss", "pcp", "ppp", 'p', "plankWood", 's', Blocks.stone_slab, 'c', Blocks.chest));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.grinder, 	"sss", "pip", "ppp", 'p', "plankWood", 's', Blocks.stone_slab, 'i', Blocks.iron_block));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.churn, 	"sss", "pbp", "ppp", 'p', "plankWood", 's', Blocks.stone_slab, 'b', Items.bucket));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.press, 	"sss", "pPp", "ppp", 'p', "plankWood", 's', Blocks.stone_slab, 'P', Blocks.piston));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.mill, 		"sss", "pmp", "ppp", 'p', "plankWood", 's', Blocks.stone_slab, 'm', ModItems.millstone));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.knife, 	"i ", 	" s", 	'i', "ingotIron", 's', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.grater, "i", 	"i", 	'i', "ingotIron"));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModFood.rawbacon, 3), "k", "p", 'k', new ItemStack(ModItems.knife, 1, OreDictionary.WILDCARD_VALUE), 'p', Items.porkchop));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.flourbag, "p p"," p ", 'p', Items.paper));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.millstone, " c ", "csc", " c ", 'c', "cobblestone", 's', "stickWood"));
		
		GameRegistry.addRecipe(new ShapelessOreRecipe(ModFood.baconroll, 	ModFood.bacon,		 ModFood.roll));
		GameRegistry.addRecipe(new ShapelessOreRecipe(ModFood.rawbeefpatty, ModFood.rawmince));
		GameRegistry.addRecipe(new ShapelessOreRecipe(ModFood.beefburger, 	ModFood.beefpatty, 	ModFood.roll));
		GameRegistry.addRecipe(new ShapelessOreRecipe(ModFood.breaddough, ModItems.wheatflour, Items.water_bucket));
		GameRegistry.addRecipe(new ShapelessOreRecipe(ModFood.gratedcheese, ModItems.grater, ModFood.cheese));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(ModFood.pizzabase, "dd", 'd', ModFood.breaddough));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModFood.rawbread, "ddd", 'd', ModFood.breaddough));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModFood.rawpizza, "c", "t", "b", 'b', ModFood.pizzabase, 't', ModFood.tomatosauce, 'c', ModFood.gratedcheese));
		
		GameRegistry.addSmelting(ModFood.rawbacon, 		new ItemStack(ModFood.bacon), 0.1F);
		GameRegistry.addSmelting(ModFood.rawbeefpatty, 	new ItemStack(ModFood.beefpatty), 0.1F);
		GameRegistry.addSmelting(ModFood.breaddough, 	new ItemStack(ModFood.roll), 0.1F);
		GameRegistry.addSmelting(ModFood.rawbread, 		new ItemStack(Items.bread), 0.1F);
		GameRegistry.addSmelting(ModFood.rawpizza, 	new ItemStack(ModFood.pizza), 0.1F);
		
		GrinderRegistry.addRecipe(new ItemStack(Items.beef, 1), new ItemStack(ModFood.rawmince, 1));
		
		ChurnRegistry.addRecipe(new ItemStack(Items.milk_bucket, 	1), new ItemStack(ModFood.butter,1));
		ChurnRegistry.addRecipe(new ItemStack(ModFood.butter, 		1), new ItemStack(ModFood.cheese,1));
		
		PressRegistry.addRecipe(new ItemStack(ModFood.tomato,1), new ItemStack(Items.glass_bottle,1), new ItemStack(ModFood.tomatosauce,1));
		
		MillRegistry.addInputRecipe(new ItemStack(Items.wheat,1), "wheat flour");
		
		MillRegistry.addOutputRecipe("wheat flour", new ItemStack(ModItems.flourbag,1), new ItemStack(ModItems.wheatflour,1));
		
	}
	
}
