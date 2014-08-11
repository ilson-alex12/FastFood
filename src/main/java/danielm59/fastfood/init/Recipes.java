package danielm59.fastfood.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import danielm59.fastfood.recipe.GrinderRegistry;

public class Recipes {

	public static void init() {
		
		GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.knife, "i ", " s", 'i', "ingotIron", 's', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.counter, "sss", "pcp", "ppp", 'p', "plankWood", 's', Blocks.stone_slab, 'c', Blocks.chest));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModFood.rawbacon, 3), "k", "p", 'k', new ItemStack(ModItems.knife, 1, OreDictionary.WILDCARD_VALUE), 'p', Items.porkchop));
		GameRegistry.addRecipe(new ShapedOreRecipe(ModFood.roll, "ww", 'w', Items.wheat));
		
		GameRegistry.addRecipe(new ShapelessOreRecipe(ModFood.baconroll, ModFood.bacon, ModFood.roll));
		
		GameRegistry.addSmelting(ModFood.rawbacon, new ItemStack(ModFood.bacon), 0.1F);
		
		GrinderRegistry.addRecipe(new ItemStack(Items.beef, 1), new ItemStack(ModFood.rawmince, 1));
		
	}
	
}
